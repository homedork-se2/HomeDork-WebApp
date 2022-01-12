package com.example.HomeDorkWebApp.controller;

import com.example.HomeDorkWebApp.api.*;
import com.example.HomeDorkWebApp.service.FanRequestService;
import com.example.HomeDorkWebApp.service.LampRequestService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet(name = "ServletDashboard", value = "/ServletDashboard")
public class ServletDashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =  request.getSession();
        String sessionId = (String) session.getAttribute("email");

        LampRequestService lampRequestService = new LampRequestService();
        AlarmRepository alarmRepository = new AlarmRepository();
        CurtainRepository curtainRepository = new CurtainRepository();
        ThermometerRepository thermometerRepository = new ThermometerRepository();
        WindowRepository windowRepository = new WindowRepository();
        FanRepostiory fanRepostiory = new FanRepostiory();



        ArrayList<String> lampIDs = lampRequestService.getLamp(sessionId);

            ArrayList<String> alarmIDs = (ArrayList<String>) alarmRepository.getAlarms(sessionId);
            ArrayList<String> curtainIds = (ArrayList<String>) curtainRepository.getCurtains(sessionId);
            ArrayList<String> thermometerIDs = (ArrayList<String>) thermometerRepository.getThermometers(sessionId);
            ArrayList<String> windowIDs = (ArrayList<String>) windowRepository.getWindows(sessionId);
            ArrayList<String> fanIDs = (ArrayList<String>) fanRepostiory.getFans(sessionId);


            System.out.println(lampIDs);

            request.setAttribute("alarmIds", alarmIDs);
            request.setAttribute("curtainIds", curtainIds);
            request.setAttribute("thermIds", thermometerIDs);
            request.setAttribute("windowIds", windowIDs);
            request.setAttribute("fanIds", fanIDs);
            request.setAttribute("lampIds", lampIDs);





        ArrayList<String> arrayList = new ArrayList<>();

        request.setAttribute("dateEvents", arrayList);


        getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LampRepository lampRepository = new LampRepository();
        HttpSession session =  request.getSession();
        String sessionId = (String) session.getAttribute("email");
        System.out.println(request.getParameter("slideValue"));
        //----------------------------toggle value & ID-------------------------------------
        String toggleValue = request.getParameter("toggleValue");
        String toggleId = request.getParameter("toggleId");

        String toggleFanValue = request.getParameter("toggleFanValue");
        String toggleFanId = request.getParameter("toggleFanId");

        String toggleCurtainValue = request.getParameter("toggleValueCurtain");
        String toggleCurtainId = request.getParameter("toggleIdCurtain");

        String toggleWindowValue = request.getParameter("toggleValueWindow");
        String toggleWindowId = request.getParameter("toggleIdWindow");

        String toggleAlarmValue = request.getParameter("toggleValueAlarm");
        String toggleAlarmId = request.getParameter("toggleIdAlarm");

        String toggleThermValue = request.getParameter("toggleValueTherm");
        String toggleThermId = request.getParameter("toggleIdTherm");

        //----------------------------slider value & ID---------------------------------------
        String lampSlideValue = request.getParameter("slideValue");
        String lampSliderId = request.getParameter("slideId");

        String fanSlideValue = request.getParameter("sliderFanValue");
        String fanSliderId = request.getParameter("sliderFanId");

        String thermSlideValue = request.getParameter("sliderThermValue");
        String thermSliderId = request.getParameter("sliderThermId");

        String alarmSlideValue = request.getParameter("sliderAlarmValue");
        String alarmSliderId = request.getParameter("sliderAlarmId");

        String curtainSlideValue = request.getParameter("sliderCurtainValue");
        String curtainSliderId = request.getParameter("sliderCurtainId");

        String windowSlideValue = request.getParameter("sliderWindowValue");
        String windowSliderId = request.getParameter("sliderWindowId");
       // System.out.println(lampSlideValue +" <---- Slide value for lamp\n"+lampSliderId + "<---- Slide id for window");
        System.out.println(windowSlideValue +" <---- toggle value\n"+windowSliderId + "<---- toggle id");


        handleLampEvents(toggleValue, lampSlideValue, lampSliderId, toggleId, sessionId);


            handleAlarmEvents(toggleAlarmValue, alarmSlideValue, alarmSliderId, toggleAlarmId, sessionId);


            handleCurtainEvents(toggleCurtainValue, curtainSlideValue, curtainSliderId, toggleCurtainId, sessionId);


            handleWindowEvents(toggleWindowValue, windowSlideValue, windowSliderId, toggleWindowId, sessionId);


            handleThermEvents(toggleThermValue, thermSlideValue, thermSliderId, toggleThermId, sessionId);


            handleFanEvents(toggleFanValue, fanSlideValue, fanSliderId, toggleFanId, sessionId);






    }

    public void handleLampEvents(String lampToggle, String lampValue, String lampValueId, String lampToggleId, String userId){
        LampRepository lampRepository = new LampRepository();
            if (lampToggle != null && lampToggle.equals("true")){
                System.out.println("hello hihi");
                lampRepository.turnOnLamp(userId, lampToggleId);
            }else if (lampToggle !=null && lampToggle.equals("false")){
                lampRepository.turnOfLamp(userId, lampToggleId);
            }

            if (lampValue != null && lampValueId != null){
                lampRepository.changeValueLamp(userId, lampValueId,lampValue);
            }


    }


    public void handleFanEvents(String fanToggle, String fanValue, String fanValueId, String fanToggleId, String userId){
        FanRepostiory fanRepostiory = new FanRepostiory();
        if (fanToggle != null && fanToggle.equals("true")){
            System.out.println("hello hihi");
            fanRepostiory.turnOnFan(userId, fanToggleId);

        }else if (fanToggle != null && fanToggle.equals("false")){
            fanRepostiory.turnOffFan(userId, fanToggleId);
        }

        if (fanValue != null && fanValueId != null){
            fanRepostiory.changeValueFan(userId,fanValueId, fanValue);
        }

    }



    public void handleAlarmEvents(String alarmToggle, String alarmValue, String alarmValueId, String alarmToggleId, String userId){
        AlarmRepository alarmRepository = new AlarmRepository();

        if (alarmToggle != null && alarmToggle.equals("true")){
            alarmRepository.turnOnAlarm(userId, alarmToggleId);
        }else if (alarmToggle != null && alarmToggle.equals("false")){
            alarmRepository.turnOffAlarm(userId, alarmToggleId);
        }

        if (alarmValue != null && alarmValueId != null){
            alarmRepository.slideValueAlarm(userId, alarmValueId, alarmValue);
        }

    }

    public void handleThermEvents(String thermToggle, String thermValue, String thermValueId, String thermToggleId, String userId){
        ThermometerRepository thermometerRepository = new ThermometerRepository();

        if (thermToggle != null &&  thermToggle.equals("true")){
            thermometerRepository.turnOnThermometer(userId, thermToggleId);
        }else if (thermToggle != null &&  thermToggle.equals("false")){
            thermometerRepository.turnOffThermometer(userId, thermToggleId);
        }

        if (thermValue != null && thermValueId != null){
            thermometerRepository.slideValueThermometer(userId, thermValueId, thermValue);
        }

    }

    public void handleWindowEvents(String windowToggle, String windowValue, String windowValueId, String windowToggleId, String userId){
        WindowRepository windowRepository = new WindowRepository();

        if (windowToggle != null &&  windowToggle.equals("true")){
            windowRepository.turnOnWindows(userId, windowToggleId);
        }else  if (windowToggle != null &&  windowToggle.equals("false")){
            windowRepository.turnOffWindow(userId, windowToggleId);
        }

        if (windowValue != null && windowValueId != null){
            windowRepository.slideValueWindows(userId, windowValueId, windowValue);
        }

    }

    public void handleCurtainEvents(String curtainToggle, String curtainValue, String curtainValueId, String curtainToggleId, String userId){
        CurtainRepository curtainRepository = new CurtainRepository();

        if (curtainToggle != null &&  curtainToggle.equals("true")){
            curtainRepository.turnOnCurtain(userId, curtainToggleId);
        }else if (curtainToggle != null &&  curtainToggle.equals("false")){
            curtainRepository.turnOffCurtain(userId, curtainToggleId);
        }

        if (curtainValue != null && curtainValueId != null){
            curtainRepository.slideValueCurtain(userId, curtainValueId, curtainValue);
        }

    }
}
