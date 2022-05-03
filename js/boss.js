class Boss{
    constructor(x,y) {
        this.img=new Image();
        this.img.src = IMG_CHICK;
        this.x=x;
        this.y=y;
        this.hp=250*HP_CHICKEN;
        this.width=WIDTH_CHICKEN*5;
        this.height=HEIGHT_CHICKEN*5;
        this.dmg=DMG_CHICKEN*2;
        this.dx=DX;
        this.dy=DY
    }
    moveBoss(){
        this.x+=this.dx
        this.y+=this.dy;
        if(this.y==0 ||this.y==canvas.height-this.height){
            this.dy=-this.dy;
        }
        if(this.x==300 || this.x==canvas.width-WIDTH_CHICKEN*5){
            this.dx=-this.dx;
        }
    }
    drawBoss(){
     if(this.hp>0){
         context.drawImage(this.img,this.x,this.y,this.width,this.height)
         context.beginPath();
         context.fillStyle="red";
         context.strokeStyle='black';
         context.fillRect(this.x+5,this.y-1,this.hp/30,5);
         context.strokeRect(this.x+5,this.y-1,this.hp/30,5);
         context.fillText(this.hp,this.x+this.width/2-20,this.y-5)
         context.closePath();
     }
    }
}