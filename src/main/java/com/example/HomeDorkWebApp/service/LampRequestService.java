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

    public void turnOnLamp(String lampID, String userId) {
        Lamp lamp;
     lampRepository.turnOnLamp(userId,lampID);

    }
    public void turnOffLamp(String lampID, String userId) {

         lampRepository.turnOnLamp(userId,lampID);

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
