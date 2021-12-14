<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.HomeDorkWebApp.model.EventModel" %><%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 12/2/2021
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="dark">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"> </script>
    <script src="js/dashboard.js" type="text/javascript"> </script>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="main.css">
    <link rel="stylesheet" href="da.css" id="dark">
    <link rel="stylesheet" href="da2.css" id="dark2">

    <link rel="stylesheet" href="toggleButton.css">
    <style>
        .div-1{
            background-color: #FBAB7E;
            background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);
        }

        .div-2{
            background-color: rgba(155, 153, 153, 0.1);

        }

        .navbar{
            background-image: linear-gradient(120deg, #a1c4fd 0%, #c2e9fb 100%);
        }
        .div-dashboard{
            background-image: linear-gradient(120deg, #a1c4fd 0%, #c2e9fb 100%);
        }


    </style>
    <title>Calendar</title>
</head>
<body class="bodyBg calendarz">
<script src="js/darkmode.js"></script>

<div>
    <div class="relative min-h-screen flex">
        <!--sidebar-->
        <div class="navigationBar w-20 space-y-6 flex flex-col content-center fixed h-full">

            <!---logo--->
            <a href="/ServletDashboard" class="pt-32" id="dash">
                <img src="images/dashboard.png" alt="" class="pl-6 w-14">
            </a>

            <a href="/CalendarServlet" methods="post" id="calendar">
                <img src="images/calendar.png" alt="" class="pl-6 w-14">
            </a>
            <a href="game.jsp" id="game">
                <img src="images/video-console.png" alt="" class="pl-6 w-14">
            </a>
            <a href="#" id="smile">
                <img src="images/smile.png" alt="" class="pl-6 w-14">
            </a>
            <a href="disco.jsp" id="disco">
                <img src="images/party.png" alt="" class="pl-6 w-14">
            </a>

            <button onclick="SpeechRecognition()">
                <img src="images/microphone-black-shape.png" class="pl-6 w-14" id="mic">
            </button>

            <a href="/SettingsServlet" class="pt-80" id="settings">
                <img src="images/setting.png" alt="" class="pl-6 w-14">
            </a>
            <a href="index.jsp" id="mainPage">
                <img src="images/exit.png" alt="" class="pl-6 w-14">
            </a>

        </div>
        <script src="js/newSpeech.js"></script>

        <div class="ml-20 w-full">

            <form action="/CalendarServlet" method="post">
                <h1 class="textDarkMode">Event</h1>
                <div class="flex flex-col">

                    <div class="flex flex-row justify-center">
                        <div class="date-picker ml-20 space-12">
                            <div class="selected-date"></div>

                            <div class="dates">
                                <div class="month">
                                    <div class="arrows prev-mth">&lt;</div>
                                    <div class="mth"></div>
                                    <div class="arrows next-mth">&gt;</div>
                                </div>

                                <div class="days"></div>
                            </div>
                        </div>


                        <div class="ml-6">
                            <div class="p-4 w-30 bg-white rounded-lg shadow-xl">
                                <div class="flex">
                                    <select onchange="firstTime()"
                                            id="firstTime"
                                            name="firstTime"
                                            class="bg-transparent text-xl appearance-none outline-none" >
                                        <option value="00">00</option>
                                        <option value="01">01</option>
                                        <option value="02">02</option>
                                        <option value="03">03</option>
                                        <option value="04">04</option>
                                        <option value="05">05</option>
                                        <option value="06">06</option>
                                        <option value="07">07</option>
                                        <option value="08">08</option>
                                        <option value="09">09</option>
                                        <option value="10">10</option>
                                        <option value="11">10</option>
                                        <option value="12">12</option>
                                        <option value="13">13</option>
                                        <option value="14">14</option>
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                        <option value="21">21</option>
                                        <option value="22">22</option>
                                        <option value="23">23</option>
                                    </select>
                                    <span class="text-xl mr-3">:</span>
                                    <select onchange="secondTime()"
                                            id="secondTime"
                                            name="minutes"
                                            class="bg-transparent text-xl appearance-none outline-none mr-4"
                                    >
                                        <option value=00>00</option>
                                        <option value=01>01</option>
                                        <option value=02>02</option>
                                        <option value=03>03</option>
                                        <option value=04>04</option>
                                        <option value=05>05</option>
                                        <option value=06>06</option>
                                        <option value=07>07</option>
                                        <option value=08>08</option>
                                        <option value=09>09</option>
                                        <option value=10>10</option>
                                        <option value=11>11</option>
                                        <option value=12>12</option>
                                        <option value=13>13</option>
                                        <option value=14>14</option>
                                        <option value=15>15</option>
                                        <option value=16>16</option>
                                        <option value=17>17</option>
                                        <option value=18>18</option>
                                        <option value=19>19</option>
                                        <option value=20>20</option>
                                        <option value=21>21</option>
                                        <option value=22>22</option>
                                        <option value=23>23</option>
                                        <option value=24>24</option>
                                        <option value=25>25</option>
                                        <option value=26>26</option>
                                        <option value=27>27</option>
                                        <option value=28>28</option>
                                        <option value=29>29</option>
                                        <option value=30>30</option>
                                        <option value=31>31</option>
                                        <option value=32>32</option>
                                        <option value=33>33</option>
                                        <option value=34>34</option>
                                        <option value=35>35</option>
                                        <option value=36>36</option>
                                        <option value=37>37</option>
                                        <option value=38>38</option>
                                        <option value=39>39</option>
                                        <option value=40>40</option>
                                        <option value=41>41</option>
                                        <option value=42>42</option>
                                        <option value=43>43</option>
                                        <option value=44>44</option>
                                        <option value=45>45</option>
                                        <option value=46>46</option>
                                        <option value=47>47</option>
                                        <option value=48>48</option>
                                        <option value=49>49</option>
                                        <option value=50>50</option>
                                        <option value=51>51</option>
                                        <option value=52>52</option>
                                        <option value=53>53</option>
                                        <option value=54>54</option>
                                        <option value=55>55</option>
                                        <option value=56>56</option>
                                        <option value=57>57</option>
                                        <option value=58>58</option>
                                        <option value=59>59</option>
                                    </select>
                                    <select
                                            name="ampm"
                                            class="bg-transparent text-xl appearance-none outline-none"
                                    >

                                    </select>
                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="pt-6">
                        <div class="pl-2 flex w-full max-w-md mx-auto space-x-3">
                            <form action="/CalendarServlet" method="post">
                                <input type="text" id="date" name="date" hidden>
                                <input type="text" id="time" name="time" hidden>
                                <input class="subv flex-1 appearance-none border border-transparent w-full py-2 ml-6 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-md rounded-lg text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent" type="text" placeholder="small note..." id="note" name="note" maxlength = "30" required>
                                <button type="submit" onclick="addEvent()"  class="flex-shrink-0 bg-purple-600 text-white text-base font-semibold py-2 px-4 rounded-lg shadow-md hover:bg-purple-700 focus:outline-none focus:ring-2 focus:ring-purple-500 focus:ring-offset-2 focus:ring-offset-purple-200">
                                    add event
                                </button>
                            </form>
                        </div>
                    </div>

                    <div class="h-full mt-10 w-full">

                        <%

                            ArrayList<EventModel> events = (ArrayList<EventModel>) request.getAttribute("events");


                            if (events != null){
                                for (int i = 0; i < events.size(); i++){


                        %>

                        <div class="mx-auto h-12 w-1/2 bg-white rounded-full flex flex-row justify-between mt-5">

                            <p class="pt-3 pl-3"><%=events.get(i).getDate()+" "+events.get(i).getTime()%></p>
                            <p class="pt-3"><%=events.get(i).getNote()%></p>
                            <form action="/CalendarServlet" method="post">
                                <button type="submit" class="flex-shrink-0 bg-purple-600 text-white text-base font-semibold py-3 px-4 rounded-lg shadow-md hover:bg-purple-700 focus:outline-none focus:ring-2 focus:ring-purple-500 focus:ring-offset-2 focus:ring-offset-purple-200">
                                    delete
                                </button>
                                <input type="text" id="deleteId" name="deleteId" value="<%=events.get(i).getEventId()%>" hidden>
                            </form>

                        </div>
                        <%
                                }
                            }else {
                                out.println();
                            }
                        %>
                    </div>


                </div>

                <script src="js/calendarMain.js"></script>




                <script>
                    function firstTime(){
                        let firstTimes = document.getElementById('firstTime');
                        return  firstTimes.options[firstTimes.selectedIndex].value;
                    }
                    function secondTime(){
                        let secondTimes = document.getElementById('secondTime');
                        return secondTimes.options[secondTimes.selectedIndex].value;
                    }
                    function addEvent(){
                        let comment = document.querySelector('.subv').value;
                        let date = document.querySelector('.selected-date').dataset.value;
                        let firstTimes = firstTime();
                        let secondTimes = secondTime();
                        console.log("Time: "+firstTimes+" : "+secondTimes);
                        console.log(date);
                        console.log(comment);
                        //document.getElementById("date").value = document.querySelector('.selected-date').dataset.value;
                        document.getElementById("date").value = document.getElementsByClassName("selected-date")[0].getAttribute("data-value");
                        document.getElementById("time").value = document.getElementById('firstTime').options[document.getElementById('firstTime').selectedIndex].value +":"+document.getElementById('secondTime').options[document.getElementById('secondTime').selectedIndex].value;
                        console.log("This is it -> : "+document.getElementsByClassName("selected-date")[0].getAttribute("data-value"));
                        /* document.getElementById("calendar-execute").click();
                        setTimeout(() => {
                            console.log("World!");
                            location.reload();
                        }, 2000);

                         */

                    }








                    console.log(date)
                </script>

            </form>
        </div>
    </div>
</div>
</body>
</html>

