package com.example.HomeDorkWebApp.controller;

import com.example.HomeDorkWebApp.api.*;
import com.example.HomeDorkWebApp.model.Alarm;
import com.example.HomeDorkWebApp.model.PersonalizedCommands;
import com.example.HomeDorkWebApp.service.LampRequestService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(name = "PersonalizedCommandsServlet", value = "/personalizedCommands")
public class PersonalizedCommandsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =  request.getSession();
        String sessionId = (String) session.getAttribute("email");

        retrieveCommands(request, response, sessionId);

        getServletContext().getRequestDispatcher("/personalizedCommands.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =  request.getSession();
        PersonalizedCommandsAPI personalizedCommandsAPI = new PersonalizedCommandsAPI();
        String sessionId = (String) session.getAttribute("email");
        String devices = request.getParameter("deviceList");
        String commandName = request.getParameter("commandName");
        String toggleCommand = request.getParameter("toggleValue");
        String toggleCommandId = request.getParameter("toggleId");
        System.out.println("HERE IS TOGGLE COMMAND VALUE: "+toggleCommand+"\n"+"HERE IS TOGGLE COMMAND ID: "+toggleCommandId);
        System.out.println(commandName + "Here is command name bro");

        if (devices != null) {
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(devices.split(",")));
            if (commandName != null) {
                personalizedCommandsAPI.addCommand(sessionId, new PersonalizedCommands(arrayList, commandName));
            }
        }




              if (toggleCommand != null && toggleCommandId != null) {
               System.out.println("check if null, line 48");
                requestAllDevices(request, response, sessionId, toggleCommandId, toggleCommand);
             }

        retrieveCommands(request, response, sessionId);
        getServletContext().getRequestDispatcher("/personalizedCommands.jsp").forward(request, response);

    }
















    public void retrieveCommands(HttpServletRequest request, HttpServletResponse response, String sessionId){
        PersonalizedCommandsAPI personalizedCommandsAPI = new PersonalizedCommandsAPI();
        ArrayList<PersonalizedCommands> personalizedCommandsList = personalizedCommandsAPI.getUserCommands(sessionId);
        request.setAttribute("commandsList", personalizedCommandsList);

    }



    private void requestAllDevices(HttpServletRequest request, HttpServletResponse response, String sessionId, String commandId, String toggleValue){
       PersonalizedCommands personalizedCommand = retrieveSpecificCommand(sessionId, commandId);


        for (int i = 0; i < personalizedCommand.getCommands().size(); i++){
            if (personalizedCommand.getCommands().get(i).equals("Fan")){
                turnOnOffAllFans(sessionId, toggleValue);
            }
            System.out.println("requestAllDevices on line 77");
            if (personalizedCommand.getCommands().get(i).equals("Alarm")){
                        turnOnOffAllAlarms(sessionId, toggleValue);
            }

            if (personalizedCommand.getCommands().get(i).equals("Window")){
                turnOnOffAllWindows(sessionId, toggleValue);
            }

            if (personalizedCommand.getCommands().get(i).equals("Thermometer")){
                    turnOnOffAllTherms(sessionId, toggleValue);
            }

            if (personalizedCommand.getCommands().get(i).equals("Lamp")){
                    turnOnOffAllLamps(sessionId, toggleValue);
            }

            if (personalizedCommand.getCommands().get(i).equals("Curtain")){
                    turnOnOffAllCurtains(sessionId, toggleValue);
            }
        }
    }






    private void turnOnOffAllAlarms(String sessionId, String toggleValue){
        AlarmRepository alarmRepository = new AlarmRepository();
        ArrayList<String> alarmIds = (ArrayList<String>) alarmRepository.getAlarms(sessionId);
        System.out.println("turnOnOffAllAlarms on line 108");
        if (toggleValue.equals("true")) {
            for (int i = 0; i < alarmIds.size(); i++) {
                alarmRepository.turnOnAlarm(sessionId, alarmIds.get(i));
            }
        }
        if (toggleValue.equals("false")){
            for (int i = 0; i < alarmIds.size(); i++) {
                alarmRepository.turnOffAlarm(sessionId, alarmIds.get(i));
            }
        }

    }

    private void turnOnOffAllWindows(String sessionId, String toggleValue){
        WindowRepository windowRepository = new WindowRepository();
        ArrayList<String> alarmIds = (ArrayList<String>) windowRepository.getWindows(sessionId);

        if (toggleValue.equals("true")) {
            for (int i = 0; i < alarmIds.size(); i++) {
                windowRepository.turnOnWindows(sessionId, alarmIds.get(i));
            }
        }

        if (toggleValue.equals("false")){
            for (int i = 0; i < alarmIds.size(); i++) {
                windowRepository.turnOffWindow(sessionId, alarmIds.get(i));
            }
        }

    }

    private void turnOnOffAllCurtains(String sessionId, String toggleValue){
        CurtainRepository curtainRepository = new CurtainRepository();
        ArrayList<String> curtainIds = (ArrayList<String>) curtainRepository.getCurtains(sessionId);

        if (toggleValue.equals("true")) {
            for (int i = 0; i < curtainIds.size(); i++) {

                curtainRepository.turnOnCurtain(sessionId, curtainIds.get(i));
            }
        }

        if (toggleValue.equals("false")){
            for (int i = 0; i < curtainIds.size(); i++) {

                curtainRepository.turnOffCurtain(sessionId, curtainIds.get(i));
            }
        }

    }

    private void turnOnOffAllFans(String sessionId, String toggleValue){
        FanRepostiory fanRepostiory = new FanRepostiory();
        ArrayList<String> alarmIds = (ArrayList<String>) fanRepostiory.getFans(sessionId);

        if (toggleValue.equals("true")) {
            for (int i = 0; i < alarmIds.size(); i++) {
                fanRepostiory.turnOnFan(sessionId, alarmIds.get(i));
            }
        }

        if (toggleValue.equals("false")){
            for (int i = 0; i < alarmIds.size(); i++) {
                fanRepostiory.turnOffFan(sessionId, alarmIds.get(i));
            }
        }

    }

    private void turnOnOffAllLamps(String sessionId, String toggleValue){
        LampRequestService lampRequestService = new LampRequestService();
        ArrayList<String> alarmIds = (ArrayList<String>) lampRequestService.getLamp(sessionId);

        if (toggleValue.equals("true")) {
            for (int i = 0; i < alarmIds.size(); i++) {
                lampRequestService.turnOnLamp(alarmIds.get(i), sessionId);
            }
        }

        if (toggleValue.equals("false")){
            for (int i = 0; i < alarmIds.size(); i++) {
                lampRequestService.turnOffLamp(alarmIds.get(i), sessionId);
            }
        }


    }

    private void turnOnOffAllTherms(String sessionId, String toggleValue){
        ThermometerRepository thermometerRepository = new ThermometerRepository();
        ArrayList<String> alarmIds = (ArrayList<String>) thermometerRepository.getThermometers(sessionId);

        if (toggleValue.equals("true")) {
            for (int i = 0; i < alarmIds.size(); i++) {

                thermometerRepository.turnOnThermometer(sessionId, alarmIds.get(i));
            }
        }

        if (toggleValue.equals("false")){
            for (int i = 0; i < alarmIds.size(); i++) {

                thermometerRepository.turnOffThermometer(sessionId, alarmIds.get(i));
            }
        }

    }

    private PersonalizedCommands retrieveSpecificCommand(String sessionId, String commandId){
        PersonalizedCommandsAPI personalizedCommandsAPI = new PersonalizedCommandsAPI();
        ArrayList<PersonalizedCommands> personalizedCommandsList = personalizedCommandsAPI.getUserCommands(sessionId);
       for (int i = 0; i < personalizedCommandsList.size(); i++){
           if (personalizedCommandsList.get(i).getCommandId().equals(commandId)){
               return personalizedCommandsList.get(i);
           }
       }
       return null;
    }
}
