package com.example.HomeDorkWebApp.service;

import com.example.HomeDorkWebApp.api.LampRepository;
import com.example.HomeDorkWebApp.model.Lamp;
import com.example.HomeDorkWebApp.model.State;
import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.List;

public class LampRequestService {
    LampRepository lampRepository = new LampRepository();

    public ArrayList<String> getLamp(String userID) {
        List<Lamp> lamps = lampRepository.getLamb(userID);
        if (lamps == null) {
            System.out.println("did not get lamp");
            return null;

        }
        ArrayList<String> lampid = new ArrayList<>();
        for (int i = 0; i < lamps.size(); i++) {
            lampid.add(lamps.get(i).id);

        }
        return lampid;
    }

    public boolean turnOnLamp(String lampID) {
        Lamp lamp;
       lamp= lampRepository.turnOnLamp(lampID);
        if (lamp.state.equals(State.ON)) {
            return true;
        } else {
            System.out.println("Lamp did not turn on ");
            return false;

        }
    }
    public boolean turnOffLamp(String LampID) {
        Lamp lamp;
        lamp= lampRepository.turnOnLamp(LampID);
        if (lamp.state.equals(State.OFF)) {
            System.out.println("Lamp did not turn off ");
            return false;
        } else {
            return true;
        }
    }

    public void changeValueLamp(String userId, String lampId, String level) {

        int status = lampRepository.changeValueLamp(userId,lampId, level);

        if ( status==200) {
            System.out.println("Succesful");
        } else {
            System.out.println("Value did not change :  " + status );
        }


    }

}
