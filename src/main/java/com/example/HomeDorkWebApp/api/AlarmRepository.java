package com.example.HomeDorkWebApp.api;

import com.example.HomeDorkWebApp.model.Alarm;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.List;

public class AlarmRepository {
    String baseURL= "http://258e-83-248-0-117.ngrok.io/hd-api/users/";
    String hdServerLamp = "hd-api/users/";
///{userId}/alarms (beginning of each alarm)

    public List<String> getAlarms(String tokenId) {
        List<String> ids = new ArrayList<>();
        List<Alarm> alarms = Unirest.get( baseURL + tokenId + "/alarms")
                .asObject(new GenericType<List<Alarm>>() {
                }).getBody();

        if(alarms != null) {
            for (int i = 0; i < alarms.size(); i++) {
                ids.add(alarms.get(i).id);
            }
        }
        return ids;
    }

    public void turnOffAlarm(String ID, String alarmId) {
        //https://e22f-194-47-32-227.ngrok.io/hd-api/users/"+ID+"/lamps/"+LampId+"/turnOn
        System.out.println(Unirest.put(baseURL + ID + "/alarms/"+alarmId+"/turnOff").asString().getStatus());

        // Lamp lamp = Unirest.get(baseURL + ID).asObject(Lamp.class).getBody();

    }



    public void turnOnAlarm(String ID, String alarmId) {

        System.out.println(Unirest.put(baseURL + ID + "/alarms/"+alarmId+"/turnOn").asString().getStatus());


    }

    public int slideValueAlarm(String userId,String alarmId, String value) {

        return Unirest.put(baseURL +userId +"/alarms/"+ alarmId + "/adjust/" + value).asString().getStatus();


    }
}
