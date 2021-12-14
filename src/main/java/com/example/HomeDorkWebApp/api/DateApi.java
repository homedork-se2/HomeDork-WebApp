package com.example.HomeDorkWebApp.api;

import com.example.HomeDorkWebApp.model.EventModel;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DateApi {
    String EventsURL = "https://homedork-8404f-default-rtdb.firebaseio.com/WebCalendar/Events/";

    public static void main(String[] args) {
        //  System.out.println(Unirest.get("https://newproject-94e9a-default-rtdb.firebaseio.com/Hello/Events.json").getBody());
    }

    public ArrayList<EventModel> getEvents(String userId){

        ArrayList<EventModel> eventModels = new ArrayList<>();
        HashMap<String, EventModel> events = Unirest.get("https://homedork-8404f-default-rtdb.firebaseio.com/WebCalendar/Events/"+userId+".json")
                .asObject(new GenericType<HashMap<String, EventModel>>(){})
                .getBody();

            if (events == null){
                return null;
            }
        for (Map.Entry<String, EventModel> entry : events.entrySet()) {

            entry.getValue().setEventId(entry.getKey());
            eventModels.add(entry.getValue());
        }


        return eventModels;
    }

    public void addEvent(String userId, LocalDate date, String time, String note){
        Unirest.post(EventsURL+userId+".json")
                .header("Content-Type", "application/json")
                .body(new EventModel(date, time, note))
                .asEmpty();

    }

    public void deleteEvent(String userId, String eventId){
        Unirest.delete("https://homedork-8404f-default-rtdb.firebaseio.com/WebCalendar/Events/"+userId+"/"+eventId+".json").asEmpty();
    }

    public void editEvent(String userId, String eventId){

    }
}
