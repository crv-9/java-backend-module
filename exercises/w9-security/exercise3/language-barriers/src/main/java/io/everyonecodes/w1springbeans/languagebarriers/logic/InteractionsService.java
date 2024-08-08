package io.everyonecodes.w1springbeans.languagebarriers.logic;

import org.springframework.stereotype.Service;

@Service
public class InteractionsService {


    private int interactionsCount;

    public int getInteractionsCount() {
        return interactionsCount;
    }

    public void incrementInteractionsCountByOne() {
        interactionsCount++;
    }

    public void incrementInteractionsCountByMany(int amount) {
        interactionsCount += amount;
    }
}
