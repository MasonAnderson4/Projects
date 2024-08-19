var canvas = document.querySelector('canvas');

var c = canvas.getContext('2d');

var img1 = new Image();
img1.src = './duck1.png';

// var img2 = new Image();
// img2.src = './duck2.png';

// var img3 = new Image();
// img3.src = './duck3.png';


img1.onload = function(){
    animate();
    addDuckWithDelay();
};


var duckArray = [];

function animate(){

    requestAnimationFrame(animate);

    c.clearRect(0,0, innerWidth, innerHeight);

   for(var i = 0; i < duckArray.length; i++){
        duckArray[i].update();

   }



}

// duck constructor
function Duck(x, y, dx, dy, img){
    this.x = x;
    this.y = y;
    this.dx = dx;
    this.dy = dy;
    this.img = img
    // actually draws the duck
    this.draw = function(){
        c.drawImage(this.img,this.x,this.y);
    }
    // updates the position and speeds to make look like animation and moving
    this.update = function(){
        if (this.y + this.img.height > canvas.height || this.y < 0) {
            this.dy = -this.dy;
        }
    
        this.x += this.dx;
        this.y += this.dy;

        this.draw();
    }

    //checks if duck was clicked
    this.isClicked = function(mouseX, mouseY){
        return mouseX >= this.x 
        && mouseX <= this.x + this.img.width 
        && mouseY >= this.y 
        && mouseY <= this.y + this.img.height;
    }

}

// allows addition of ducks with delay
function addDuckWithDelay() {
    var duckIndex = 0;
    var totalDucks = 50;
    var delay = 2000;
    // adds the duck to the array with a delay
    function addNextDuck() {
        if(duckIndex < totalDucks){
            var x = canvas.width;
            var y = Math.random() * canvas.height;
            var dx = -(Math.random() * 3);
            var dy = Math.random() * 3;

            duckArray.push(new Duck(x,y,dx,dy,img1));
            duckIndex++;

            setTimeout(addNextDuck, delay);
        }
    }
    addNextDuck();
}

//handles change in cursor when clicked
canvas.addEventListener('mousedown', function() {
    canvas.style.cursor = 'url("./reticleShot.png") 16 16, auto';
});

canvas.addEventListener('mouseup', function() {
    canvas.style.cursor = 'url("./reticle.png") 16 16, auto';
});


canvas.addEventListener('click', function(event){
    //returns the size of the canvas and its position relative to the viewport
    var rect = canvas.getBoundingClientRect();
    // give x and y coords
    var mouseX = event.clientX - rect.left;
    var mouseY = event.clientY - rect.top;
    console.log("Click detected at: ", mouseX, mouseY);

    //loops in reverse to prevent skipping ducks
    for(var i = duckArray.length-1; i >= 0; i--){
        console.log("Duck " + i + " position: ", duckArray[i].x, duckArray[i].y);
        if(duckArray[i].isClicked(mouseX, mouseY)){
            console.log("Duck removed at index: ", i);
            duckArray.splice(i, 1); //removes clicked duck from array
            break;
        }
    }
})




