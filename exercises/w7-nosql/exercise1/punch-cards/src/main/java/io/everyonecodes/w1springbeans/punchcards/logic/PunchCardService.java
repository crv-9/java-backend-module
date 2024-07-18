package io.everyonecodes.w1springbeans.punchcards.logic;


import io.everyonecodes.w1springbeans.punchcards.model.PunchCard;
import io.everyonecodes.w1springbeans.punchcards.model.PunchCardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class PunchCardService {

    PunchCardRepository punchCardRepository;

    public PunchCardService(PunchCardRepository punchCardRepository) {
        this.punchCardRepository = punchCardRepository;
    }

    public PunchCard mySave(PunchCard punchCard) {
        stampPunchCard(punchCard);
        punchCardRepository.save(punchCard);
        return punchCard;
    }

    private void stampPunchCard(PunchCard punchCard){
        punchCard.setDayOfTheWeek(String.valueOf(LocalDate.now().getDayOfWeek()));
        punchCard.setTimeOfDay(String.valueOf(LocalTime.now()));
    }

    public List<PunchCard> findAll(){
        return punchCardRepository.findAll();
    }
}
