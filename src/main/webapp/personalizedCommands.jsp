<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.HomeDorkWebApp.model.PersonalizedCommands" %><%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 1/4/2022
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="dark" onclick="jump()">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="da.css" id="dark">
    <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"> </script>
    <link rel="stylesheet" href="da2.css" id="dark2">
    <link rel="stylesheet" href="toggleButton.css">
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <style>
        .navbar{
            background-image: linear-gradient(120deg, #a1c4fd 0%, #c2e9fb 100%);
        }
    </style>

    <title>HomeDork gaming platform</title>
    <link rel="stylesheet" href="style.css">
</head>

<body class="bodyBg">
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


    <div class="ml-20 flex-col w-full">
        <div class="h-64 w-full bg-black">
            <div class="mx-auto bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 flex flex-col">
                <form action="/personalizedCommands" method="post">
                <div class="mb-4">
                    <label class="block text-grey-darker text-sm font-bold mb-2" for="commandName">
                        Command name
                    </label>

                    <input class="mx-auto shadow appearance-none border rounded w-1/3 py-2 px-3 text-grey-darker" id="commandName" type="text" name="commandName" placeholder="commandName" required>
                </div>
                <div class="mb-6">
                    <label class="block text-grey-darker text-sm font-bold mb-2" for="deviceSelection">
                        Device
                    </label>
                    <div class="flex flex-row">
                        <select class="w-1/3 h-8 rounded border-solid border-2" name="Device" id="deviceSelection">
                            <option value="Light">Light</option>
                            <option value="Window">Window</option>
                            <option value="Fan">Fan</option>
                            <option value="Thermometer">Thermometer</option>
                            <option value="Alarm">Alarm</option>
                            <option value="Curtain">Curtain</option>
                            <option value="None">None...</option>
                        </select>


                        <button class="bg-blue-500 ml-3 hover:bg-blue-700 text-white text-3xl font-bold px-4 pb-1 rounded-full" onclick="addDeviceButtons()">
                            +
                        </button>
                    </div>

                    <div class="generatedDevices mt-2 flex flex-row" id="buttonsDisplayer">


                    </div>

                </div>
                <div class="flex items-center justify-between">

                    <input type="text" id="deviceList" name="deviceList" hidden>
                    <button class="bg-blue-500 hover:bg-blue-dark text-white font-bold py-2 px-4 rounded-full" type="submit" id="sendCommandsButton" onclick="submitCommands()" >
                        Create command
                    </button>


                </div>
                </form>
            </div>

            <div class="mt-10 ml-10">


                <div class="grid grid-cols-3">
                    <%
                        ArrayList<PersonalizedCommands> commandList = (ArrayList<PersonalizedCommands>) request.getAttribute("commandsList");
                        if (commandList != null){
                        for (int i = 0; i < commandList.size(); i++){
                    %>
                    <div class="mx-auto bg-white mt-5 w-96 h-96  drop-shadow-2xl">
                        <div class="flex flex-row">
                            <h2 class="mx-auto text-lg font-bold mt-2"><%=commandList.get(i).getCommandName()%></h2>
                            <label class="switch mt-2 mr-6">
                                <input class="toggleCommand"  type="checkbox" id="<%=commandList.get(i).getCommandId()%>">
                                <span class="slider round "></span>
                            </label>
                        </div>
                        <div class="ml-20 mt-20 mx-auto">
                            <ul class="list-disc mx-auto justify-center"></ul>
                            <%
                                for (int k = 0; k < commandList.get(i).getCommands().size(); k++){
                                    out.println("<li class=\"font-bold\">"+commandList.get(i).getCommands().get(k)+"</li>");
                                }
                            %>

                        </div>
                    </div>
                    <%
                            }
                        }
                    %>

                </div>

            </div>
        </div>

    </div>

    <div>

    </div>
<script>

    function submitCommands(){

        let hiddenField;

        let options = document.querySelectorAll('.deviceValues');
        hiddenField = document.getElementById('deviceList');
        var submitButton = document.getElementById('sendCommandsButton');
        console.log(hiddenField.value);

        for (i = 0; i < options.length; i++){
            hiddenField.value += options[i].innerHTML+",";
        }
        submitButton.submit();

            hiddenField.value = "";
        event.preventDefault();

    }

</script>

    <script>


        function addDeviceButtons(){
            event.preventDefault();
            var div = document.getElementById('buttonsDisplayer');
            var select = document.getElementById('deviceSelection');
            var value = select.options[select.selectedIndex].value;
            const btn = document.createElement('button');

            let options = document.querySelectorAll('.deviceValues');
            if(options != null){
                for(i = 0; i < options.length; i++){
                    if(options[i].innerHTML === value){

                        btn.remove();
                        alert("You can not add the same device more than one time...");
                        return;
                    }
                    console.log(options[i].innerHTML);
                }

            }

            btn.classList = 'ml-2 bg-blue-500 hover:bg-blue-dark text-white text-sm font-bold px-1 rounded-full flex flex-row';
            btn.innerHTML = '<div class="deviceValues pr-1">'+value+'</div><div class="border-l border-white px-1">x</div>';

            div.appendChild(btn);

            btn.addEventListener('click', () => {
                btn.remove();
            });




        }

    </script>

    <script>
        $(document).ready(function () {
            let toggleArrayForCommands = $(".toggleCommand");
            for (let i = 0; i < toggleArrayForCommands.length; i++) {
                toggleArrayForCommands[i].addEventListener("change", sendCommandToggleValue);

            };


            function sendCommandToggleValue(){
                var toggleData = {
                    toggleValue: this.checked,
                    toggleId: this.id,
                };
                console.log(toggleData);
                $.ajax({
                    type: 'POST',
                    url: 'personalizedCommands',
                    data: toggleData,
                });


            };

        });
    </script>


</div>

</body>

</html>
