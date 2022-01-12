package com.example.HomeDorkWebApp.api;

import com.example.HomeDorkWebApp.model.Window;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.List;

public class WindowRepository {
    ///{userId}/windows

    String baseURL= "http://258e-83-248-0-117.ngrok.io/hd-api/users/";
    String hdServerLamp = "hd-api/users/";
///{userId}/windows (beginning of each alarm)

    public List<String> getWindows(String tokenId) {
        List<String> ids = new ArrayList<>();
        List<Window> windows = Unirest.get(baseURL + tokenId + "/windows")
                .asObject(new GenericType<List<Window>>() {
                }).getBody();

        if (windows != null)
        for (int i = 0; i < windows.size(); i++){
            ids.add(windows.get(i).id);
        }
        return ids;
    }

    public void turnOffWindow(String ID, String windowId) {
        //https://e22f-194-47-32-227.ngrok.io/hd-api/users/"+ID+"/lamps/"+LampId+"/turnOn
        System.out.println(Unirest.put(baseURL + ID + "/windows/"+windowId+"/turnOff").asString().getStatus());

        // Lamp lamp = Unirest.get(baseURL + ID).asObject(Lamp.class).getBody();

    }



    public void turnOnWindows(String ID, String windowId) {

        System.out.println(Unirest.put(baseURL + ID + "/windows/"+windowId+"/turnOn").asString().getStatus());


    }

    public int slideValueWindows(String userId,String windowId, String value) {

        return Unirest.put(baseURL +userId +"/windows/"+windowId+ "/adjust/" + value).asString().getStatus();


    }
}
