package com.example.HomeDorkWebApp.api;

import com.example.HomeDorkWebApp.model.Alarm;
import com.example.HomeDorkWebApp.model.Curtain;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.List;

public class CurtainRepository {

    String baseURL= "http://6ee6-83-248-0-117.ngrok.io/hd-api/users/";
    String hdServerLamp = "hd-api/users/";
///{userId}/curtains (beginning of each alarm)

    public List<String> getCurtains(String tokenId) {
        List<String> ids = new ArrayList<>();
        List<Curtain> curtains = Unirest.get( baseURL + tokenId + "/curtains")
                .asObject(new GenericType<List<Curtain>>() {
                }).getBody();
        for (int i = 0; i < curtains.size(); i++){
            ids.add(curtains.get(i).id);
        }
        return ids;
    }

    public void turnOffCurtain(String ID, String curtainId) {
        //https://e22f-194-47-32-227.ngrok.io/hd-api/users/"+ID+"/lamps/"+LampId+"/turnOn
        System.out.println(Unirest.put(baseURL + ID + "/curtains/"+curtainId+"/turnOff").asString().getStatus());

        // Lamp lamp = Unirest.get(baseURL + ID).asObject(Lamp.class).getBody();

    }



    public void turnOnCurtain(String ID, String curtainId) {

        System.out.println(Unirest.put(baseURL + ID + "/curtains/"+curtainId+"/turnOn").asString().getStatus());


    }

    public int slideValueCurtain(String userId,String curtainId, String value) {

        return Unirest.put(baseURL +userId +"/curtains"+ curtainId + "/adjust/" + value).asString().getStatus();


    }
}
