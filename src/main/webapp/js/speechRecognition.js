function runSpeechRecognition() {
    const output = document.getElementById("output");
    const voiceButton = document.getElementById("mic");
    const calendar = document.getElementById("game");
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
        if (transcript.includes("hello")){
            console.log(transcript);
            calendar.click();
        }else {
            console.log("EMPTY ")
        }

        output.classList.remove("hide");
    };

    recognition.start();

}