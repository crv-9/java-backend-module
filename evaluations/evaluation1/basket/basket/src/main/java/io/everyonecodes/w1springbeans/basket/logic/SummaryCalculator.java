package io.everyonecodes.w1springbeans.basket.logic;

import io.everyonecodes.w1springbeans.basket.communication.clients.UsersClient;
import io.everyonecodes.w1springbeans.basket.model.ItemSelection;
import io.everyonecodes.w1springbeans.basket.model.Summary;
import io.everyonecodes.w1springbeans.basket.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SummaryCalculator {

    private final UsersClient usersClient;
    private final double deliveryCost;
    private final String accountType;


    public SummaryCalculator(UsersClient usersClient, @Value("${cost}") double deliveryCost, @Value("${account}") String accountType) {
        this.usersClient = usersClient;
        this.deliveryCost = deliveryCost;
        this.accountType = accountType;
    }

    public Summary getSummary(ItemSelection itemSelection){
        String userEmail = itemSelection.getUserEmail();
        if (getUserType(userEmail).equals(accountType)){
            return createStandardSummary(itemSelection);
        } else return createPremiumSummary(itemSelection);
    }

    // i am running this one to obtain what type of user it is
    private String getUserType(String userEmail){
        Optional<User> oUser = usersClient.getUserByEmail(userEmail);
        if (oUser.isPresent()){
            return oUser.get().getAccountType();
        } else return null;
    }


    // i could optimize/clean the code below to only have one?
    private Summary createStandardSummary(ItemSelection itemSelection){
        return new Summary(
                itemSelection.getUserEmail(),
                itemSelection.getItemName(),
                itemSelection.getItemPrice(),
                deliveryCost,
                itemSelection.getItemPrice() + deliveryCost);
    }

    private Summary createPremiumSummary(ItemSelection itemSelection){
        return new Summary(
                itemSelection.getUserEmail(),
                itemSelection.getItemName(),
                itemSelection.getItemPrice(),
                0.0,
                itemSelection.getItemPrice()
        );
    }
}
