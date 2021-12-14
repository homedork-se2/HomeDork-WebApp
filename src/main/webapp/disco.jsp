<%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 12/2/2021
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="dark">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="tailwind.css">
    <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"> </script>
    <script src="js/dashboard.js" type="text/javascript"> </script>
    <link rel="stylesheet" href="da.css" id="dark">
    <link rel="stylesheet" href="da2.css" id="dark2">
    <link rel="stylesheet" href="style.css">
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
<body class="bodyBg">
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

        <div class="ml-20 w-full flex flex-col">
            <button id="disco-button" class="bg-blue-500 mx-auto mt-6 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full w-16" onclick="discoMode()">Turn on disco mode</button>



            <div class="disco-lamps" style = "display: none; flex-direction: row; margin-top: 10vh; margin-left: 50vh; justify-content: space-around; max-width: 100vh">

                    <div class="light" style = "width: 20px; height: 20px" ></div >
                    <div class="light" style = "width: 20px; height: 20px" ></div >
                    <div class="light" style = "width: 20px; height: 20px" ></div >
                    <div class="light" style = "width: 20px; height: 20px" ></div >
                    <div class="light" style = "width: 20px; height: 20px" ></div >
                    <div class="light" style = "width: 20px; height: 20px" ></div >
                    <div class="light" style = "width: 20px; height: 20px" ></div >
                    <div class="light" style = "width: 20px; height: 20px" ></div >
                    <div class="light" style = "width: 20px; height: 20px" ></div >
                    <div class="light" style = "width: 20px; height: 20px" ></div >
                    <div class="light" style = "width: 20px; height: 20px" ></div >
                    <div class="light" style = "width: 20px; height: 20px" ></div >




            </div >



            <span id="action"></span></p>

            <div id="output" class="hidden"></div>
            <script src="js/speechRecognition.js">

            </script>


            <script>
                function discoMode() {
                    const lights = document.querySelectorAll('.light');
                    const disco = document.querySelector('.disco-lamps');
                    const discoButton = document.getElementById('disco-button');
                    if (disco.style.display === "none") {
                        discoButton.innerHTML = "Turn off disco mode";
                        disco.style.display = "flex";
                    } else {
                        discoButton.innerHTML = "Turn on disco mode";
                        disco.style.display = "none";
                    }
                    setInterval(() => {
                        lights.forEach(function (self) {
                            let color = getRandomHEX();
                            self.style.backgroundColor = color;
                            self.style["boxShadow"] =
                                "0 0 0 rgba(255,255,255,0.2), 0 20px 100px 8px " +
                                color +
                                ", 0 10px 50px 0 #fff";
                        });
                    }, 300);
                }
                function getRandomHEX() {
                    let letters = "0123456789ABCDEF",
                        value = "#";
                    for (let i = 0; i < 6; i++) {
                        value += letters[Math.floor(Math.random() * 16)];
                    }
                    return value;
                }
            </script>

        </div>






    </div>
</div>
</body>
</html>