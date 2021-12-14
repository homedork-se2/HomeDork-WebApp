function SpeechRecognition() {
    const output = document.getElementById("output");
    const voiceButton = document.getElementById("mic");
    const calendar = document.getElementById("calendar");
    const game = document.getElementById("game");
    const dashboard = document.getElementById("dash");
    const settings = document.getElementById("settings");
    var SpeechRecognition = SpeechRecognition || webkitSpeechRecognition;
    const recognition = new SpeechRecognition();
    recognition.lang = "en-GB";
    recognition.onstart = function() {
        voiceButton.textContent = "Listening..";
    };
    recognition.onspeechend = function() {
        voiceButton.textContent = "Text to speech";
        recognition.stop();
    }

    recognition.onresult = function(event) {
        const transcript = event.results[0][0].transcript;
        console.log(transcript);
        if (transcript.includes("game")){
            game.click();
        }else if (transcript.includes("dashboard")){
           dashboard.click();
        }else if (transcript.includes("setting") || transcript.includes("settings")){
            settings.click();
        }else if (transcript.includes("calendar")){
            calendar.click();
        }else if (transcript.includes("dark") || transcript.includes("light")){
            saveSettingsForTheme(transcript);
        }

        output.classList.remove("hide");
    };

    recognition.start();

}


function saveSettingsForTheme(value){
    var themes = value;
    if (themes!= null){
        localStorage.setItem("theme", themes)
        location.reload();
    }

}