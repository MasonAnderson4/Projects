document.addEventListener("DOMContentLoaded", function() {
    const yesButton = document.getElementById("yesButton");
    const noButton = document.getElementById("noButton");
    const description = document.getElementById("description");
    const img = document.getElementById("img");

    noButton.addEventListener("click", function(){
        description.innerHTML = "what the hell :(";
        img.src = "sad-snorlax.gif"
    })

    yesButton.addEventListener("click", function(){
        description.innerHTML = "Yippe |||";
        img.src = "happy-snorlax.gif"
    })
    
})