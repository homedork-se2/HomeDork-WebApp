$(document).ready(function (){
    let rangeArray = $(".slider-lamp");
    console.log(rangeArray);
    for (let i = 0; i < rangeArray.length; i++)
    {
        rangeArray[i].addEventListener("change", sendLampValue);


    };
    function sendLampValue(){
        var data = {
            value: this.value,
            id: this.id,
        };
        console.log(data);
        $.ajax({
            type: 'POST',
            url: 'ServletDashboard',
            data: data,
        });

    };
});

