<%@ page import="java.util.ArrayList" %>
<jsp:useBean id="email" scope="session" type="java.lang.String"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html class="dark">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <link rel="stylesheet" href="da.css" id="dark">
    <link rel="stylesheet" href="da2.css" id="dark2">
    <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"> </script>
    <script src="js/dashboard.js" type="text/javascript"> </script>
    <link rel="stylesheet" href="toggleButton.css">
    <style>
        .div-1{
            background-color: #FBAB7E;
            background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);
        }

        .div-2{
            background-color: rgba(155, 153, 153, 0.1);
            min-width: 435px !important;
            width: 100% !important;
        }



        .navbar{
            background-image: linear-gradient(120deg, #a1c4fd 0%, #c2e9fb 100%);
        }
        .div-dashboard{
            background-image: linear-gradient(120deg, #a1c4fd 0%, #c2e9fb 100%);
        }


    </style>
    <title>Welcome</title>
</head>
<body class="bodyBg">

<script src="js/darkmode.js"></script>
<div>
    <div class="relative min-h-screen flex overflow-hidden">
        <!--sidebar-->
        <div class="navigationBar w-20 space-y-6 flex flex-col content-center fixed h-full">
            <!---logo--->
            <a href="${pageContext.request.contextPath}/ServletDashboard" class="pt-32" id="dash">
                <img src="images/dashboard.png" alt="" class="pl-6 w-14">
            </a>

            <a href="${pageContext.request.contextPath}/CalendarServlet" methods="post" id="calendar">
                <img src="images/calendar.png" alt="" class="pl-6 w-14">
            </a>
            <a href="game.jsp" id="game">
                <img src="images/video-console.png" alt="" class="pl-6 w-14">
            </a>
            <a href="#" id="smile">
                <img src="images/smile.png" alt="" class="pl-6 w-14">
            </a>
            <a href="disco.jsp" id="disco">
                <img src="party.png" alt="" class="pl-6 w-14">
            </a>
            <button onclick="SpeechRecognition()">
                <img src="microphone-black-shape.png" class="pl-6 w-14" id="mic">
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



            <div class="upperBodyDark profile_image-div h-44 flex items-center justify-center">
                <image src="images/ic.jpg" class="w-16 h-16 rounded-full"></image>
            </div>


            <div class="flex flex-row ml-2 justify-between pt-6 space-x-4 overflow-scroll">


                <div class="div-2 flex flex-col space-y-3.5 w-1/4 h-screen rounded-t-3xl">
                    <div class="upperDeviceSection shadow -z-50 mx-auto bg-white w-full  px-16 md:px-2 py-16  h-20  rounded-t-3xl">
                        <img class="mx-auto" src="images/lamp.svg" alt="lamp image">
                    </div>

                    <div class="devices shadow flex flex-col z-50 mx-auto bg-white md:w-48 xl:w-64 2xl:w-80  py-16 md:py-6 xl:py-8 2xl:py-10 h-40  rounded-t-3xl rounded-b-3xl">
                        <h2 class="">Lamp id: 1</h2>
                        <div class="flex flex-row justify-center justify-between">
                            <output class="shadow rounded-full text-5xl ml-2" for="volumeOne" id="lampOne" name="lampOne">50</output>
                            <label class="switch mt-2 mr-6">
                                <input class="toggle" value="1" type="checkbox" id="toggleOne">
                                <span class="slider round"></span>
                            </label>
                        </div>

                        <input class="slider-lamp z-50" type="range" id="volumeOne" name="volumeOne" min="0" max="100" oninput="lampOne.value = volumeOne.value"/>

                    </div>




                </div>




                <div class="div-2 flex flex-col  space-y-3.5 w-1/4 h-screen rounded-t-3xl">
                    <div class="upperDeviceSection shadow -z-50 mx-auto bg-white w-full  px-16 md:px-2 py-16  h-20  rounded-t-3xl">
                        <img class="mx-auto w-12 h-12" src="images/fan.png" alt="lamp image">
                    </div>

                    <div class="devices shadow flex flex-col z-50 mx-auto bg-white md:w-48 xl:w-64 2xl:w-80  py-16 md:py-6 xl:py-8 2xl:py-10 h-40  rounded-t-3xl rounded-b-3xl ">
                        <h2 class="">Fan id: 1</h2>
                        <div class="flex flex-row justify-center justify-between">
                            <output class="shadow rounded-full text-5xl ml-2" id="fanOne" for="slideFanOne" name="fanOne">50</output>
                            <label class="switch mt-2 mr-6">
                                <input class="toggle" value="1" type="checkbox" id="toggleFanOne">
                                <span class="slider round "></span>
                            </label>
                        </div>

                        <input class="slider-lamp z-50" type="range" id="slideFanOne" name="slideFanOne" min="0" max="100" oninput="fanOne.value = slideFanOne.value"/>

                    </div>

                    <div class="devices shadow flex flex-col z-50 mx-auto bg-white md:w-48 xl:w-64 2xl:w-80  py-16 md:py-6 xl:py-8 2xl:py-10 h-36  rounded-t-3xl rounded-b-3xl ">
                        <h2 class="pl-6 text-lg">Fan: 2</h2>
                        <div class="flex flex-row justify-center justify-between">
                            <output class="shadow rounded-full text-4xl ml-6" for="volumeTwo" id="fanTwo" name="fanTwo">50</output>
                            <label class="switch mt-2 mr-6">
                                <input class="toggle" value="1" type="checkbox" id="toggleFanTwo">
                                <span class="slider round "></span>
                            </label>
                        </div>

                        <input class="slider-lamp z-50 w-72 mx-auto " type="range" id="volumeTwo" name="volumeTwo" min="0" max="100" oninput="fanTwo.value = volumeTwo.value"/>

                    </div>



                </div>

                <div class="div-2 flex flex-col  space-y-3.5 w-1/4 h-screen rounded-t-3xl">
                    <div class="upperDeviceSection shadow -z-50 mx-auto bg-white w-full  px-16 md:px-2 py-16  h-20  rounded-t-3xl">
                        <img class="mx-auto w-12 h-12" src="images/thermometer.png" alt="lamp image">
                    </div>
                    <% ArrayList<String> thermoIds = (ArrayList<String>) request.getAttribute("thermoIds");
                        if (thermoIds != null){
                            for (int i = 0; i < thermoIds.size(); i++){%>
                    <div class="shadow flex flex-col z-50 mx-auto bg-white md:w-48 xl:w-64 2xl:w-80  py-16 md:py-6 xl:py-8 2xl:py-10 h-40  rounded-t-3xl rounded-b-3xl ">
                        <h2 class="">Lamp id: <%=i%></h2>
                        <div class="flex flex-row justify-center justify-between">
                            <span class="shadow rounded-full text-5xl ml-2" id="<%=thermoIds.get(i)%>">0</span>
                            <label class="switch mt-2 mr-6">
                                <input class="toggle" value="1" type="checkbox" id="<%=thermoIds.get(i)%>">
                                <span class="slider round "></span>
                            </label>
                        </div>

                        <br>
                        <br>
                        <input class="slider-lamp z-50" type="range" id="<%=thermoIds.get(i)%>" name="volume" min="0" max="100" onChange="rangeSlide(this.value)" onmousemove="rangeSlide(this.value)"/>
                        <script type="text/javascript">
                            function rangeSlide(value) {
                                document.getElementById('rangeValue').innerHTML = value;
                            }
                        </script>
                    </div>
                    <%}
                    } %>


                </div>



                <div class="div-2 flex flex-col  space-y-3.5 w-1/4 h-screen rounded-t-3xl">
                    <div class="upperDeviceSection shadow -z-50 mx-auto bg-white w-full  px-16 md:px-2 py-16  h-20  rounded-t-3xl">
                        <img class="mx-auto w-12 h-12" src="images/others.png" alt="lamp image">
                    </div>
                    <% ArrayList<String> curtainIds = (ArrayList<String>) request.getAttribute("curtainIds");
                        if (curtainIds != null){
                            for (int i = 0; i < curtainIds.size(); i++){%>
                    <div class="shadow flex flex-col z-50 mx-auto bg-white md:w-48 xl:w-64 2xl:w-80  py-16 md:py-6 xl:py-8 2xl:py-10 h-40  rounded-t-3xl rounded-b-3xl ">
                        <h2 class="">Lamp id: <%=i%></h2>
                        <div class="flex flex-row justify-center justify-between">
                            <span class="shadow rounded-full text-5xl ml-2" id="<%=curtainIds.get(i)%>">0</span>
                            <label class="switch mt-2 mr-6">
                                <input class="toggle" value="1" type="checkbox" id="<%=curtainIds.get(i)%>">
                                <span class="slider round "></span>
                            </label>
                        </div>

                        <br>
                        <br>
                        <input class="slider-lamp z-50" type="range" id="<%=curtainIds.get(i)%>" name="volume" min="0" max="100" onChange="rangeSlide(this.value)" onmousemove="rangeSlide(this.value)"/>
                        <script type="text/javascript">
                            function rangeSlide(value) {
                                document.getElementById('rangeValue').innerHTML = value;
                            }
                        </script>
                    </div>
                    <%}
                    } %>

                </div>

                <div class="div-2 flex flex-col  space-y-3.5 w-1/4 h-screen rounded-t-3xl">
                    <div class="shadow upperDeviceSection -z-50 mx-auto bg-white w-full  px-16 md:px-2 py-16  h-20  rounded-t-3xl">
                        <img class="mx-auto w-12 h-12" src="images/others.png" alt="lamp image">


                    </div>


                </div>

                <div class="div-2 flex flex-col  space-y-3.5 w-1/4 h-screen rounded-t-3xl">
                    <div class="upperDeviceSection shadow -z-50 mx-auto bg-white w-full  px-16 md:px-2 py-16  h-20  rounded-t-3xl">
                        <img class="mx-auto w-12 h-12" src="images/others.png" alt="lamp image">
                    </div>
                    <% ArrayList<String> windowIds = (ArrayList<String>) request.getAttribute("lampIds");
                        if (windowIds != null){
                            for (int i = 0; i < windowIds.size(); i++){%>
                    <div class="shadow flex flex-col z-50 mx-auto bg-white md:w-48 xl:w-64 2xl:w-80  py-16 md:py-6 xl:py-8 2xl:py-10 h-40  rounded-t-3xl rounded-b-3xl ">
                        <h2 class="">Lamp id: <%=i%></h2>
                        <div class="flex flex-row justify-center justify-between">
                            <span class="shadow rounded-full text-5xl ml-2" id="<%=windowIds.get(i)%>">0</span>
                            <label class="switch mt-2 mr-6">
                                <input class="toggle" value="1" type="checkbox" id="<%=windowIds.get(i)%>">
                                <span class="slider round "></span>
                            </label>
                        </div>

                        <br>
                        <br>
                        <input class="slider-lamp z-50" type="range" id="<%=windowIds.get(i)%>" name="volume" min="0" max="100" onChange="rangeSlide(this.value)" onmousemove="rangeSlide(this.value)"/>
                        <script type="text/javascript">
                            function rangeSlide(value) {
                                document.getElementById('rangeValue').innerHTML = value;
                            }
                        </script>
                    </div>
                    <%}
                    } %>

                </div>

                <div class="div-2 flex flex-col  space-y-3.5 w-1/4 h-screen rounded-t-3xl">
                    <div class="upperDeviceSection shadow -z-50 mx-auto bg-white w-full  px-16 md:px-2 py-16  h-20  rounded-t-3xl">
                        <img class="mx-auto w-12 h-12" src="images/others.png" alt="lamp image">
                    </div>
                    <% ArrayList<String> alarmIds = (ArrayList<String>) request.getAttribute("lampIds");
                        if (alarmIds != null){
                            for (int i = 0; i < alarmIds.size(); i++){%>
                    <div class="shadow flex flex-col z-50 mx-auto bg-white md:w-48 xl:w-64 2xl:w-80  py-16 md:py-6 xl:py-8 2xl:py-10 h-40  rounded-t-3xl rounded-b-3xl ">
                        <h2 class="">Lamp id: <%=i%></h2>
                        <div class="flex flex-row justify-center justify-between">
                            <span class="shadow rounded-full text-5xl ml-2" id="<%=alarmIds.get(i)%>">0</span>
                            <label class="switch mt-2 mr-6">
                                <input class="toggle" value="1" type="checkbox" id="<%=alarmIds.get(i)%>">
                                <span class="slider round "></span>
                            </label>
                        </div>

                        <br>
                        <br>
                        <input class="slider-lamp z-50" type="range" id="<%=alarmIds.get(i)%>" name="volume" min="0" max="100" onChange="rangeSlide(this.value)" onmousemove="rangeSlide(this.value)"/>
                        <script type="text/javascript">
                            function rangeSlide(value) {
                                document.getElementById('rangeValue').innerHTML = value;
                            }
                        </script>
                    </div>
                    <%}
                    } %>

                </div>




            </div>
        </div>






    </div>
</div>
</body>
</html>
