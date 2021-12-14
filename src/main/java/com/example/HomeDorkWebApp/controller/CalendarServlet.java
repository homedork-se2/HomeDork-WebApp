package com.example.HomeDorkWebApp.controller;

import com.example.HomeDorkWebApp.api.DateApi;
import com.example.HomeDorkWebApp.model.EventModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

@WebServlet(name = "CalendarServlet", value = "/CalendarServlet")
public class CalendarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessionId = (String) session.getAttribute("email");
        getEvents(request, sessionId);
        getServletContext().getRequestDispatcher("/calendar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =  request.getSession();
        String sessionId = (String) session.getAttribute("email");

        System.out.println("you have hit the doPost method");
        String date = request.getParameter("date");
        System.out.println("This is date: ----> "+date);
        String time = request.getParameter("time");
        String note = request.getParameter("note");
        String deleteId = request.getParameter("deleteId");
        System.out.println(deleteId+" <----- THIS HERE");
        System.out.println(date);
        if (date != null && time!= null && note != null){
            addEvent(LocalDate.parse(formatDate(date)), time, note, sessionId);
        }

        if (deleteId != null){
                deleteEvent(deleteId, sessionId);
        }

        System.out.println("date: "+date+"\ntime: "+time+"\nnote: "+note);
        getEvents(request, sessionId);





        getServletContext().getRequestDispatcher("/calendar.jsp").forward(request, response);
    }

    public void getEvents(HttpServletRequest request, String sessionId){
        LoginServlet loginServlet = new LoginServlet();
        System.out.println();
        DateApi dateApi = new DateApi();
        ArrayList<EventModel> events = dateApi.getEvents(sessionId); //TODO: pass in user id
        if (events == null){
            return;
        }
        System.out.println("id hihihhih "+sessionId);
        events.sort(Comparator.comparing(EventModel::getDate));
        request.setAttribute("events", events);

    }

    public void addEvent(LocalDate date, String time, String note, String sessionId){
        DateApi dateApi = new DateApi();
        dateApi.addEvent(sessionId, date,time,note);
    }

    public void deleteEvent(String deleteId, String sessionId){

        DateApi dateApi = new DateApi();
        dateApi.deleteEvent(sessionId, deleteId);
    }

    public String formatDate(String date){
        if (date == null){
            return "";
        }else if (date.length() <3){
            return "";
        }

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Jan", "01");
        hashMap.put("Feb", "02");
        hashMap.put("Mar", "03");
        hashMap.put("Apr", "04");
        hashMap.put("May", "05");
        hashMap.put("Jun", "06");
        hashMap.put("Jul", "07");
        hashMap.put("Aug", "08");
        hashMap.put("Sep", "09");
        hashMap.put("Oct", "10");
        hashMap.put("Nov", "11");
        hashMap.put("Dec", "12");

        String[] dateFormat = date.split(" ");

        return dateFormat[3]+"-"+hashMap.get(dateFormat[1])+"-"+dateFormat[2];
    }
}
