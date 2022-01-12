package com.example.HomeDorkWebApp.api;

import com.example.HomeDorkWebApp.model.Fan;
import com.example.HomeDorkWebApp.model.Lamp;
import com.example.HomeDorkWebApp.model.State;
import com.example.HomeDorkWebApp.model.Window;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.List;

public class FanRepostiory {

    String baseURL= "http://258e-83-248-0-117.ngrok.io/hd-api/users/";


    public List<String> getFans(String tokenId) {
        List<String> ids = new ArrayList<>();
        List<Fan> fans = Unirest.get( baseURL + tokenId + "/fans")
                .asObject(new GenericType<List<Fan>>() {
                }).getBody();
        if (fans != null)
        for (int i = 0; i < fans.size(); i++){
            ids.add(fans.get(i).id);
        }
        return ids;
    }

    public void turnOffFan(String ID, String fanId) {
        Unirest.put(baseURL + ID + "/fans/"+ fanId+ "/turnOff").asString();


    }



    public void turnOnFan(String ID, String fanId) {
        Unirest.put(baseURL + ID + "/fans/"+ fanId+ "/turnOn").asString();

    }

    public void changeValueFan(String ID, String fanId,  String level) {
        Unirest.put(baseURL + ID +"/fans/"+fanId+ "/adjust/" + level).asString();





    }

}
