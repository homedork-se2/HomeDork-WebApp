<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 10/10/2021
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="email" scope="session" type="java.lang.String"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"> </script>
    <script src="js/dashboard.js" type="text/javascript"> </script>
    <link rel="stylesheet" href="toggleButton.css">
    <style>
        .div-1{
            background-color: #FBAB7E;
            background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);
        }

        .div-2{
            background-color: rgba(155, 153, 153, 0.1)
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
<body>
<%
    if (session.getAttribute("email") == null) {
        response.sendRedirect("index.jsp");
    }
%>

<div>
    <div class="relative min-h-screen flex">
        <!--sidebar-->
        <div class="navbar w-20 space-y-6 flex flex-col content-center fixed h-full">

            <!---logo--->
            <a href="#" class="pt-32">
                <img src="images/dashboard.png" alt="dashboard" class="pl-6 w-14">
            </a>

            <a href="#" >
                <img src="images/calendar.png" alt="calendar" class="pl-6 w-14">
            </a>
            <a href="game.jsp" >
                <img src="images/video-console.png" alt="game" class="pl-6 w-14">
            </a>
            <a href="#">
                <img src="images/smile.png" alt="smile" class="pl-6 w-14">
            </a>
            <a href="#" class="pt-96">
                <img src="images/setting.png" alt="settings" class="pl-6 w-14">
            </a>
            <a href="index.jsp">
                <img src="images/exit.png" alt="exit" class="pl-6 w-14">
            </a>

    </div>


        <div class="ml-20 w-full">



            <div class="div-dashboard profile_image-div div-1 h-44 flex items-center justify-center ">
                <image src="images/ic.jpg" class="w-16 h-16 rounded-full"></image>
            </div>


            <div class="flex flex-row ml-2 justify-between pt-6 space-x-4">


                <div class="div-2 flex flex-col  space-y-3.5 w-1/4 h-screen rounded-t-3xl">
                    <div class="shadow z-50 mx-auto bg-white w-full  px-16 md:px-2 py-16  h-20  rounded-t-3xl">
                        <img class="mx-auto" src="images/lamp.svg" alt="lamp image">
                    </div>

                    <% ArrayList<String> lampIDs = (ArrayList<String>) request.getAttribute("ids");
                        if (lampIDs != null){
                            for (int i = 0; i < lampIDs.size(); i++){%>
                    <div class="shadow flex flex-col z-50 mx-auto bg-white md:w-48 xl:w-64 2xl:w-80  py-16 md:py-6 xl:py-8 2xl:py-10 h-40  rounded-t-3xl rounded-b-3xl ">
                        <h2 class="">Lamp id: <%=i%></h2>
                        <div class="flex flex-row justify-center justify-between">
                            <span class="shadow rounded-full text-5xl ml-2" id="rangeValue">0</span>
                            <label class="switch mt-2 mr-6">
                                <input class="toggle" value="1" type="checkbox" id="hihai">
                                <span class="slider round "></span>
                            </label>
                        </div>

                        <br>
                        <br>
                        <input class="slider-lamp pt-12 z-50" type="range" id="<%=lampIDs.get(i)%>" name="volume" min="0" max="100" onChange="rangeSlide(this.value)" onmousemove="rangeSlide(this.value)"/>
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
                    <div class="shadow z-50 mx-auto bg-white w-full  px-16 md:px-2 py-16  h-20  rounded-t-3xl">
                        <img class="mx-auto w-12 h-12" src="images/fan.png" alt="lamp image">
                    </div>



                </div>

                <div class="div-2 flex flex-col  space-y-3.5 w-1/4 h-screen rounded-t-3xl">
                    <div class="shadow z-50 mx-auto bg-white w-full  px-16 md:px-2 py-16  h-20  rounded-t-3xl">
                        <img class="mx-auto w-12 h-12" src="images/thermometer.png" alt="lamp image">
                    </div>



                </div>



                <div class="div-2 flex flex-col  space-y-3.5 w-1/4 h-screen rounded-t-3xl">
                    <div class="shadow z-50 mx-auto bg-white w-full  px-16 md:px-2 py-16  h-20  rounded-t-3xl">
                        <img class="mx-auto w-12 h-12" src="images/others.png" alt="lamp image">


                    </div>
                </div>

            </div>
        </div>






    </div>
</div>
</body>
</html>