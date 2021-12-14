package com.example.HomeDorkWebApp.model;


import java.time.LocalDate;

public class EventModel {
    private LocalDate date;
    private String time;
    private String note;
    private String eventId;

    public EventModel(LocalDate date, String time, String note, String eventId) {
        this.date = date;
        this.time = time;
        this.note = note;
        this.eventId = eventId;
    }

    public EventModel(LocalDate date, String time, String note) {
        this.date = date;
        this.time = time;
        this.note = note;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
