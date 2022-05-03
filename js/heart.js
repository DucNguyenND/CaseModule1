const WIDTH_HEART=50;
const HEIGHT_HEART=50;
const IMG_HEART="heart.png"
const HP_HEART=50
const SPEED_HEART=1

class Heart{
    constructor(x,y) {
        this.x=x;
        this.y=y;
        this.img=new Image();
        this.img.src=IMG_HEART;
        this.width=WIDTH_HEART;
        this.height=HEIGHT_HEART;
        this.hp=HP_HEART;
        this.speed=SPEED_HEART;
    }
    drawHeart(){
        ctx.drawImage(this.img,this.x,this.y,this.width,this.height);
    }
    moveHeart(){
        this.y += this.speed;
        if(score<=5){
            this.speed=2
        } else if( score<=10){
            this.speed=3;
        } else if(score<=15){
            this.speed=4;
        } else this.speed=5;
    }
}