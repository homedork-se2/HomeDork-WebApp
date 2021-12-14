<%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 11/7/2021
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="dark" onclick="jump()">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="tailwind.css">
  <link rel="stylesheet" href="da.css" id="dark">
  <link rel="stylesheet" href="da2.css" id="dark2">
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />
  <style>
    .navbar{
      background-image: linear-gradient(120deg, #a1c4fd 0%, #c2e9fb 100%);
    }
  </style>

  <title>HomeDork gaming platform</title>
  <link rel="stylesheet" href="style.css">
</head>

<body class="bodyBg ">
<script src="js/darkmode.js"></script>
<div class="relative min-h-screen flex">
  <div class="navigationBar w-20 space-y-6 flex flex-col content-center fixed h-full z-50 shadow">

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
<div class="m-40 w-full">

<div class="game">
  <img id="character" src="images/stickman.gif" alt="">
  <img id="block" src="images/stone.png" alt="">
</div>
<div class="menu">
  <div class="dropdown">
    <button class="dropbtn">Choose your character</button>
    <div class="dropdown-content">
      <a onclick="changeCharacter('./images/santa.gif')">Santa</a>
      <a onclick="changeCharacter('./images/batman.gif')">Batman</a>
      <a onclick="changeCharacter('./images/stickman.gif')">Stickman</a>
      <a onclick="changeCharacter('./images/cow.gif')">Cow</a>
      <a onclick="changeCharacter('./images/pikachu.gif')">Pikachu</a>
    </div>
  </div>
  <label for="toggle"></label><input type="checkbox" name="" id="toggle">

  <p id="score">Score: <span id="scoreSpan"></span></p>
  <p id="gameOver"></p>
  <p>Highscore: <span id="highScore"></span></p>
</div>
</div>
</div>
<script src="js/game.js"></script>

<script src="js/darkmode.js">

</script>
</body>

</html>