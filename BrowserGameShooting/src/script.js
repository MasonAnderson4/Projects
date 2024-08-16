
window.onload = function() {
   setGame()
}

function setGame() {
    
}

function launchDuck(){
   let initialVelocity = Math.random() * 10 + 10; //random speed
   let angle = Math.random() * Math.PI / 3; //random angle between 0-60
   let gravity = 9.8;

   // x and y velocity compenents
   let vx = initialVelocity * Math.cos(angle);
   let vy = initialVelocity * Math.sin(angle);

   //starting position
   let x = 0, y = 0;
   let t = 0; //time

   function update(){
      // updates time
      t += 0.1;
      x = vx * t;
      y = vy * t - 0.5 * gravity * t * t; //fancy gravity equation

      drawDuck(x,y);

      //stop when hits the ground
      if (y >= groundLevel){
         clearInterval(interval);
      }

   }

   let interval = setInterval(update, 1000/60);
}

function drawDuck(){

}