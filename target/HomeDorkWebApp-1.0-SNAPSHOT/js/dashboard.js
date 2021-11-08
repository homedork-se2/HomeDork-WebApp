$(document).ready(function (){
    let rangeArray = $(".slider-lamp");
    console.log(rangeArray);
    for (let i = 0; i < rangeArray.length; i++)
    {
        rangeArray[i].addEventListener("change", sendLampValue);


    };
    let toggleArray = $(".toggle");
    console.log(toggleArray);
    for (let i = 0; i < toggleArray.length; i++)
    {
        toggleArray[i].addEventListener("change", sendToggleValue);


    };

    function sendLampValue(){
        var data = {
            sliderValue: this.value,
            sliderId: this.id,
        };
        console.log(data);
        $.ajax({
            type: 'POST',
            url: 'ServletDashboard',
            data: data,
        });

    };
    function sendToggleValue(){
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



