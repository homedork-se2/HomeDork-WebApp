$(document).ready(function (){
    let rangeArray = $(".slider-lamp");
    console.log(rangeArray);
    for (let i = 0; i < rangeArray.length; i++)
    {
        rangeArray[i].addEventListener("change", sendLampValue);


    };
    //------------------------------------------------------Slider input-------------------------------------------------------------

    let rangeArrayForFan = $(".slider-fan");
    console.log(rangeArray);
    for (let i = 0; i < rangeArrayForFan.length; i++)
    {
        rangeArrayForFan[i].addEventListener("change", sendFanValue);


    };

    let rangeArrayForTherm = $(".slider-Therm");
    console.log(rangeArray);
    for (let i = 0; i < rangeArrayForTherm.length; i++)
    {
        rangeArrayForTherm[i].addEventListener("change", sendThermValue);


    };

    let rangeArrayForAlarm = $(".slider-alarm");
    console.log(rangeArray);
    for (let i = 0; i < rangeArrayForAlarm.length; i++)
    {
        rangeArrayForAlarm[i].addEventListener("change", sendAlarmValue);


    };

    let rangeArrayForWindow = $(".slider-window");
    console.log(rangeArray);
    for (let i = 0; i < rangeArrayForWindow.length; i++)
    {
        rangeArrayForWindow[i].addEventListener("change", sendWindowValue);


    };

    let rangeArrayForCurtain = $(".slider-curtain");
    console.log(rangeArray);
    for (let i = 0; i < rangeArrayForCurtain.length; i++)
    {
        rangeArrayForCurtain[i].addEventListener("change", sendCurtainValue);


    };

    function sendFanValue(){
        document.getElementById(this.id+"/fan").innerText = this.value;
        var dataFan = {
            sliderFanValue: this.value,
            sliderFanId: this.id,
        };
        console.log(dataFan);
        $.ajax({
            type: 'POST',
            url: 'ServletDashboard',
            data: dataFan,
        });

    };

    function sendThermValue(){
        document.getElementById(this.id+"/therm").innerText = this.value;
        var dataTherm = {
            sliderThermValue: this.value,
            sliderThermId: this.id,
        };
        console.log(dataTherm);
        $.ajax({
            type: 'POST',
            url: 'ServletDashboard',
            data: dataTherm,
        });

    };

    function sendAlarmValue(){
        document.getElementById(this.id+"/alarm").innerText = this.value;
        var dataAlarm = {
            sliderAlarmValue: this.value,
            sliderAlarmId: this.id,
        };
        console.log(dataAlarm);
        $.ajax({
            type: 'POST',
            url: 'ServletDashboard',
            data: dataAlarm,
        });

    };

    function sendCurtainValue(){
        document.getElementById(this.id+"/curtain").innerText = this.value;
        var dataCurtain = {
            sliderCurtainValue: this.value,
            sliderCurtainId: this.id,
        };
        console.log(dataCurtain);
        $.ajax({
            type: 'POST',
            url: 'ServletDashboard',
            data: dataCurtain,
        });

    };

    function sendWindowValue(){
        document.getElementById(this.id+"/window").innerText = this.value;
        var dataWindow = {
            sliderWindowValue: this.value,
            sliderWindowId: this.id,
        };
        console.log(dataWindow);
        $.ajax({
            type: 'POST',
            url: 'ServletDashboard',
            data: dataWindow,
        });

    };




















    //------------------------------------------------------Toggle input-------------------------------------------------------------
    let toggleArrayForLamp = $(".toggleLamp");
    for (let i = 0; i < toggleArrayForLamp.length; i++)
    {
        toggleArrayForLamp[i].addEventListener("change", sendToggleValueLamp);

    };

    let toggleArrayForWindow = $(".toggleWindow");
    for (let i = 0; i < toggleArrayForWindow.length; i++)
    {
        toggleArrayForWindow[i].addEventListener("change", sendToggleValueWindow);


    };

    let toggleArrayForAlarm = $(".toggleAlarm");
    for (let i = 0; i < toggleArrayForAlarm.length; i++)
    {
        toggleArrayForAlarm[i].addEventListener("change", sendToggleValueAlarm);


    };
    let toggleArrayForCurtain = $(".toggleCurtain");
    for (let i = 0; i < toggleArrayForCurtain.length; i++)
    {
        toggleArrayForCurtain[i].addEventListener("change", sendToggleValueCurtain);


    };

    let toggleArrayForTherm = $(".toggleTherm");
    for (let i = 0; i < toggleArrayForTherm.length; i++)
    {
        toggleArrayForTherm[i].addEventListener("change", sendToggleValueTherm);


    };

    let toggleArrayForFan = $(".toggleFan");
    for (let i = 0; i < toggleArrayForFan.length; i++)
    {
        toggleArrayForFan[i].addEventListener("change", sendToggleValueForFan);


    };

    function sendLampValue(){
        document.getElementById(this.id+"/lamp").innerText = this.value;
        var dataLamp = {
            slideValue: this.value,
            slideId: this.id,
        };
        console.log(dataLamp);
        $.ajax({
            type: 'POST',
            url: 'ServletDashboard',
            data: dataLamp,
        });

    };

    function sendToggleValueForFan(){
        var toggleFanData = {
            toggleFanValue: this.checked,
            toggleFanId: this.id,
        };
        console.log(toggleFanData);
        $.ajax({
            type: 'POST',
            url: 'ServletDashboard',
            data: toggleFanData,
        });

    };
    function sendToggleValueTherm(){
        var toggleDataTherm = {
            toggleValueTherm: this.checked,
            toggleIdTherm: this.id,
        };
        console.log(toggleDataTherm);
        $.ajax({
            type: 'POST',
            url: 'ServletDashboard',
            data: toggleDataTherm,
        });

    };
    function sendToggleValueCurtain(){
        var toggleDataCurtain = {
            toggleValueCurtain: this.checked,
            toggleIdCurtain: this.id,
        };
        console.log(toggleDataCurtain);
        $.ajax({
            type: 'POST',
            url: 'ServletDashboard',
            data: toggleDataCurtain,
        });

    };
    function sendToggleValueAlarm(){
        var toggleDataAlarm = {
            toggleValueAlarm: this.checked,
            toggleIdAlarm: this.id,
        };
        console.log(toggleDataAlarm);
        $.ajax({
            type: 'POST',
            url: 'ServletDashboard',
            data: toggleDataAlarm,
        });

    };
    function sendToggleValueWindow(){
        var toggleDataWindow = {
            toggleValueWindow: this.checked,
            toggleIdWindow: this.id,
        };
        console.log(toggleDataWindow);
        $.ajax({
            type: 'POST',
            url: 'ServletDashboard',
            data: toggleDataWindow,
        });

    };
    function sendToggleValueLamp(){

        var toggleData = {
            toggleValue: this.checked,
            toggleId: this.id,
        };
        console.log(toggleData);
        $.ajax({
            type: 'POST',
            url: 'ServletDashboard',
            data: toggleData,
        });

    };
});
