<%--
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
    <script src="js/welcome.js" type="text/javascript"> </script>
    <style>
        .div-1{
            background-color: #FBAB7E;
            background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);
        }

        .div-2{
            background-color: rgba(155, 153, 153, 0.1)
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

<div class="profile_image-div div-1 h-44 flex items-center justify-center ">
    <image src="ic.jpg" class="w-16 h-16 rounded-full"/>
</div>


<div class="flex flex-row justify-between pt-6 space-x-4">

    <form action="">

    </form>
    <div class="div-2 flex flex-col space-x-3.5 space-y-3.5 w-1/4 h-screen rounded-t-3xl">
        <div class="shadow z-50 mx-auto bg-white w-full  px-16 py-16  h-20  rounded-t-3xl">
            <img class="pl-32" src="lamp.svg" alt="lamp image">
        </div>

        <div class="shadow z-50 mx-auto bg-white w-96 px-16 py-16  h-1/5 rounded-t-3xl">
            <input class="" type="range" id="volume" name="volume" min="0" max="100"/>
        </div>


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

            <input class="slider-lamp pt-20 z-50" type="range" id="volum" name="volume" min="0" max="100" onChange="rangeSlide(this.value)" onmousemove="rangeSlide(this.value)"/>
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




<script type="text/javascript">
    function rangeSlide(value) {
        document.getElementById('rangeValue').innerHTML = value;
    }
</script>



</body>
</html>
