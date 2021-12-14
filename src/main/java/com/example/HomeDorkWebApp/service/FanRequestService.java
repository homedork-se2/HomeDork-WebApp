package com.example.HomeDorkWebApp.service;

import com.example.HomeDorkWebApp.api.FanRepostiory;
import com.example.HomeDorkWebApp.model.Fan;
import com.example.HomeDorkWebApp.model.Lamp;
import com.example.HomeDorkWebApp.model.State;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class FanRequestService {
    FanRepostiory fanRepostiory = new FanRepostiory();

    public ArrayList<String> getFans(String userID) {
        List<Fan> fan = fanRepostiory.getFan(userID);
        if (fan == null) {
            System.out.println("did not get fans");
            return null;
        }
        ArrayList<String> fanID = new ArrayList<>();
        for (int i = 0; i < fan.size(); i++) {
            fanID.add(fan.get(i).id);

        }
        return fanID;
    }

    public boolean turnOnFan(String fanID) {
        Fan fan;
        fan= fanRepostiory.turnOnFan(fanID);
        if (fan.state.equals(State.ON)) {
            return true;
        } else {
            System.out.println("Fan did not turn on ");
            return false;
        }
    }
    public boolean turnOffLamp(String LampID) {
        Fan fan;
        fan= fanRepostiory.turnOnFan(LampID);
        if (fan.state.equals(State.OFF)) {
            return false;
        } else {
            System.out.println("Fan did not turn off ");
            return true;
        }
    }
}
