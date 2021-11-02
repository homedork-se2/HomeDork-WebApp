//Lamp div functionality
$(document).ready(function (){
    let rangeArray = $(".slider-lamp");
    for (let i = 0; i < rangeArray.length; i++)
    {
        rangeArray[i].addEventListener("change", dummyCode);

    }
    function dummyCode(){
        var data = {
            value: this.value,
            id: this.id,
        };
        $.ajax({
            type: 'POST',
            url: 'ServletRangeSlider',
            data: data,
        });

    };
});

//fan div functionality
$(document).ready(function (){
    let rangeArray = $(".slider-fan");
    for (let i = 0; i < rangeArray.length; i++)
    {
        rangeArray[i].addEventListener("change", dummyCode);

    }
    function dummyCode(){
        var data = {
            value: this.value,
            id: this.id,
        };
        $.ajax({
            type: 'POST',
            url: 'ServletRangeSlider',
            data: data,
        });

    };
})