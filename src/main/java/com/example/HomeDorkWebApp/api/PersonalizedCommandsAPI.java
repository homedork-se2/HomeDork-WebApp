package com.example.HomeDorkWebApp.api;

import com.example.HomeDorkWebApp.model.EventModel;
import com.example.HomeDorkWebApp.model.PersonalizedCommands;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PersonalizedCommandsAPI {
    String EventsURL = "https://homedork-8404f-default-rtdb.firebaseio.com/PersonalizedCommands/";

    public void addCommand(String userId, PersonalizedCommands personalizedCommands){
        Unirest.post(EventsURL+userId+".json")
                .header("Content-Type", "application/json")
                .body(personalizedCommands)
                .asEmpty();

    }

    public ArrayList<PersonalizedCommands> getUserCommands(String userId){

        ArrayList<PersonalizedCommands> personalizedCommands = new ArrayList<>();
        HashMap<String, PersonalizedCommands> events = Unirest.get("https://homedork-8404f-default-rtdb.firebaseio.com/PersonalizedCommands/"+userId+".json")
                .asObject(new GenericType<HashMap<String, PersonalizedCommands>>(){})
                .getBody();

        if (events == null){
            return null;
        }
        for (Map.Entry<String, PersonalizedCommands> entry : events.entrySet()) {

            entry.getValue().setCommandId(entry.getKey());
            entry.getValue().setToggleValue(entry.getValue().getToggleValue());
            personalizedCommands.add((entry.getValue()));
        }


        return personalizedCommands;
    }

    public void updateToggleValue(String userId, PersonalizedCommands personalizedCommands){
        Unirest.put(EventsURL+userId+"/"+personalizedCommands.getCommandId()+".json")
                .header("Content-Type", "application/json")
                .body(personalizedCommands)
                .asEmpty();
    }

    public void getSpecificCommand(){

    }
}
