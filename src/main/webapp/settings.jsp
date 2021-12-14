<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"> </script>
  <script src="js/dashboard.js" type="text/javascript"> </script>
  <link rel="stylesheet" href="style.css">
  <link rel="stylesheet" href="da.css" id="dark">
  <link rel="stylesheet" href="da2.css" id="dark2">
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
    <script src="js/darkModeTwo.js"></script>
    <div class="ml-20 w-full">
      <!-- component -->
      <div class="bodyBg bg-gray-200 min-h-screen pt-2 font-mono my-16">
        <div class="container mx-auto">
          <div class="inputs w-full max-w-2xl p-6 mx-auto">
            <h2 class="textDarkMode text-2xl text-gray-900">Account Setting</h2>
            <form class="mt-6 border-t border-gray-400 pt-4">
              <div class='flex flex-wrap -mx-3 mb-6'>
                <div class='w-full md:w-full px-3 mb-6'>
                  <label class='textDarkMode block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2' for='grid-text-1'>email address</label>
                  <input class='appearance-none block w-full bg-white text-gray-700 border border-gray-400 shadow-inner rounded-md py-3 px-4 leading-tight focus:outline-none  focus:border-gray-500' id='grid-text-1' type='text' placeholder='Enter email'  required>
                </div>
                <div class='w-full md:w-full px-3 mb-6 '>
                  <label class='textDarkMode block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2'>password</label>
                  <button class=" appearance-none bg-gray-200 text-gray-900 px-2 py-1 shadow-sm border border-gray-400 rounded-md ">change your password</button>
                </div>
                <div class='w-full md:w-full px-3 mb-6'>
                  <label class='textDarkMode block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2'>Web theme setting: </label>
                  <div class="flex-shrink w-full inline-block relative">
                    <label>
                      <select class="block appearance-none text-gray-600 w-full bg-white border border-gray-400 shadow-inner px-4 py-2 pr-8 rounded" id="theme" onchange="themeSettings()">
                        <option>choose ...</option>
                        <option value="Neutral">Neutral</option>
                        <option value="Darkmode">Darkmode</option>
                      </select>
                    </label>
                    <div class="pointer-events-none absolute top-0 mt-3  right-0 flex items-center px-2 text-gray-600">
                      <svg class="fill-current h-4 w-4" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"></path></svg>
                    </div>
                  </div>
                </div>
                <div class='w-full md:w-full px-3 mb-6'>
                  <label class='textDarkMode block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2'>Language</label>
                  <div class="flex-shrink w-full inline-block relative">
                    <label>
                      <select class="block appearance-none text-gray-600 w-full bg-white border border-gray-400 shadow-inner px-4 py-2 pr-8 rounded">
                        <option>choose ...</option>
                        <option>English</option>
                        <option>Swedish</option>
                      </select>
                    </label>
                    <div class="pointer-events-none absolute top-0 mt-3  right-0 flex items-center px-2 text-gray-600">
                      <svg class="fill-current h-4 w-4" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"></path></svg>
                    </div>
                  </div>
                </div>
                <div class="personal w-full border-t border-gray-400 pt-4">
                  <h2 class="textDarkMode text-2xl text-gray-900">Personal info:</h2>
                  <div class="flex items-center justify-between mt-4">
                    <div class='w-full md:w-1/2 px-3 mb-6'>
                      <label class='textDarkMode block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2' >first name</label>
                      <label>
                        <input class='appearance-none block w-full bg-white text-gray-700 border border-gray-400 shadow-inner rounded-md py-3 px-4 leading-tight focus:outline-none  focus:border-gray-500' type='text'  required>
                      </label>
                    </div>
                    <div class='w-full md:w-1/2 px-3 mb-6'>
                      <label class='textDarkMode block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2' >last name</label>
                      <label>
                        <input class='appearance-none block w-full bg-white text-gray-700 border border-gray-400 shadow-inner rounded-md py-3 px-4 leading-tight focus:outline-none  focus:border-gray-500' type='text'  required>
                      </label>
                    </div>
                  </div>
                  <div class='w-full md:w-full px-3 mb-6'>
                    <label class='textDarkMode block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2'>user name</label>
                    <label>
                      <input class='appearance-none block w-full bg-white text-gray-700 border border-gray-400 shadow-inner rounded-md py-3 px-4 leading-tight focus:outline-none  focus:border-gray-500' type='text'  required>
                    </label>
                  </div>
                  <div class='w-full md:w-full px-3 mb-6'>
                    <label class='textDarkMode block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2' >Bio</label>
                    <label>
                      <textarea class='bg-gray-100 rounded-md border leading-normal resize-none w-full h-20 py-2 px-3 shadow-inner border border-gray-400 font-medium placeholder-gray-700 focus:outline-none focus:bg-white'  required></textarea>
                    </label>
                  </div>
                  <div class="flex justify-end">
                    <button class="appearance-none bg-gray-200 text-gray-900 px-2 py-1 shadow-sm border border-gray-400 rounded-md mr-3" type="submit" onclick="saveSettings()">save changes</button>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>



    </div>



   <script>
     function themeSettings() {
       var e = document.getElementById("theme");
       var value = e.options[e.selectedIndex].value;
       if (value === "Darkmode"){
         return "darkmode";
       }
       return value;
     }

     function saveSettings(){
       var themes = themeSettings();

       if (themes!= null){
         localStorage.setItem("theme", themes)
         location.reload();
       }

     }

   </script>


  </div>
</div>
</body>
</html>