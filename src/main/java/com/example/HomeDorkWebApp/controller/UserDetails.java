package com.example.HomeDorkWebApp.controller;


import java.util.*;

public class UserDetails {

    private int userID;
    private int userDevices;
    private String userName;


    //Parameterized Constructor
    public UserDetails(int id, int devices, String name)
    {
        this.userID = id;
        this.userDevices = devices;
        this.userName = name;

    }

    public int getUserID() {
        return userID;
    }
    public int getUserDevices() {
        return userDevices;
    }
    public String getUserName() {
        return userName;
    }


    public ArrayList<UserDetails> getEmployeeDetails()
    {
        ArrayList<UserDetails> userList = new ArrayList<UserDetails>();

        userList.add(new UserDetails(1, 2, "Hani"));  //Adding users data to the ArrayList object via parameterized constructor
        userList.add(new UserDetails(2, 3, "Stiv"));
        userList.add(new UserDetails(3, 4, "Ali"));
        userList.add(new UserDetails(4, 5, "Amr"));

        return userList;
    }
}