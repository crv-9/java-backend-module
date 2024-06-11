package io.everyonecodes.w1springbeans.emergencynumbers;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EmergencyNumberProvider {
    private final PoliceEmergency policeEmergency;
    private final FireEmergency fireEmergency;
    private final GeneralEmergency generalEmergency;

    public EmergencyNumberProvider(PoliceEmergency policeEmergency, FireEmergency fireEmergency, GeneralEmergency generalEmergency) {
        this.policeEmergency = policeEmergency;
        this.fireEmergency = fireEmergency;
        this.generalEmergency = generalEmergency;
    }

    public int provideEmergencyNumber(String emergencyType) {
        if(emergencyType.equalsIgnoreCase(policeEmergency.getName())) {
            return policeEmergency.getNumber();
        } else if (emergencyType.equalsIgnoreCase(fireEmergency.getName())) {
            return fireEmergency.getNumber();
        } else return generalEmergency.getNumber();
    }
}
