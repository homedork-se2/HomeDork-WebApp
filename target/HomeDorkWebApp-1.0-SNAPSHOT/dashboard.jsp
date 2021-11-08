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
            <a href="#">
                <img src="images/exit.png" alt="exit" class="pl-6 w-14">
            </a>

    </div>


        <div class="ml-20 w-full">


<div class="profile_image-div div-1 h-44 flex items-center justify-center ">
    <image src="ic.jpg" class="w-16 h-16 rounded-full"/>
</div>


<div class="flex flex-row justify-between pt-6 space-x-4">


    <div class="div-2 flex flex-col space-x-3.5 space-y-3.5 w-1/4 h-screen rounded-t-3xl">
        <div class="shadow z-50 mx-auto bg-white w-full  px-16 py-16  h-20  rounded-t-3xl">
            <img class="pl-32" src="lamp.svg" alt="lamp image">
        </div>

        <% ArrayList<String> lampIDs = (ArrayList<String>) request.getAttribute("ids");
        if (lampIDs != null){
            for (int i = 0; i < lampIDs.size(); i++){%>
        <div class="shadow z-50 mx-auto bg-white w-96 px-16 py-16  h-1/5 rounded-t-3xl">
            <label class="switch">
                <input class="toggle" value="1" type="checkbox" id="<%=lampIDs.get(i)%>">
                <span class="slider round"></span>
            </label>
            <br>
            <br>
            <input class="slider-lamp" type="range" id="<%=lampIDs.get(i)%>" name="volume" min="0" max="100"/>
        </div>

        <%}
            } %>
    </div>





    <div class="div-2 flex flex-col space-x-3.5 space-y-3.5 w-1/4 h-screen rounded-t-3xl">
        <div class="shadow z-50 mx-auto bg-white w-full  px-16 py-16  h-20  rounded-t-3xl">
            <img class="pl-32" src="lamp.svg" alt="lamp image">
        </div>


        <div class="flex flex-col z-50 mx-auto bg-white w-96 px-16 py-16  h-1/5 rounded-t-3xl ">
            <div class="flex flex-row justify-center justify-between">
                <span class="shadow rounded-full text-5xl" id="rangeValue">0</span>
                <span class="shadow rounded-full text-5xl" id="rangeValueTwo">0</span>
            </div>

            <input class="pt-20 z-50" type="range" id="volum" name="volume" min="0" max="100" onChange="rangeSlide(this.value)" onmousemove="rangeSlide(this.value)"/>
        </div>
    </div>

    <div class="div-2 w-1/4 h-screen rounded-t-3xl">
        <div class="z-50 mx-auto bg-white w-full  px-16 py-16  h-20  rounded-t-3xl">
            <img class="pl-32" src="lamp.svg" alt="lamp image">
        </div>

    </div>

    <div class="div-2  w-1/4 h-screen   rounded-t-3xl">
        <div class="z-50 mx-auto bg-white w-full  px-16 py-16  h-20  rounded-t-3xl">
            <img class="pl-32" src="lamp.svg" alt="lamp image">
        </div>

    </div>

</div>
        </div>



<script type="text/javascript">
    function rangeSlide(value) {
        document.getElementById('rangeValue').innerHTML = value;
    }
</script>


</div>
</div>
</body>
</html>
