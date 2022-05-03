const WIDTH_CHICKEN=50;
const HEIGHT_CHICKEN=50;
const HP_CHICKEN=30;
const SPEED_CHICKEN=1;
const IMG_CHICK='ga.png';
const DMG_CHICKEN=10;
const DX=2;
const DY=5;

class Chicken {
    constructor( x, y) {
        this.img=new Image();
        this.img.src = IMG_CHICK;
        this.x = x;
        this.y = y;
        this.width = WIDTH_CHICKEN;
        this.height = HEIGHT_CHICKEN;
        this.speed = SPEED_CHICKEN
        this.hp = HP_CHICKEN;
        this.dmg=DMG_CHICKEN;
        this.dx=DX;
        this.dy=DY;
    }

    drawChicken(){
        if(this.hp>0){
            ctx.drawImage(this.img,this.x,this.y,this.width,this.height)
            ctx.beginPath();
            ctx.fillStyle="red";
            ctx.strokeStyle='black';
            ctx.fillRect(this.x+7,this.y-1,this.hp,5);
            ctx.strokeRect(this.x+7,this.y-1,this.hp,5);
            ctx.closePath();
        }
    }

    moveChicken(){
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

