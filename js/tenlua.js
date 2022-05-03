const CHIEU_CAO_TL=50;
const CHIEU_RONG_TL=50;
const HP_TL=150;
const TOC_DO_TL=10;
const IMG_TL="tenlua.png";

class Tenlua{
    constructor(x,y) {
        this.img=new Image();
        this.img.src=IMG_TL;
        this.x=x;
        this.y=y;
        this.width=CHIEU_RONG_TL;
        this.height=CHIEU_CAO_TL;
        this.speed=TOC_DO_TL;
        this.hp=HP_TL;
    }
    drawTL(){
        if(this.hp<0){
            this.hp=0;}
        ctx.drawImage(this.img,this.x,this.y,this.width,this.height);
        ctx.beginPath();
        ctx.fillStyle="red";
        ctx.strokeStyle="black";
        ctx.fillRect(this.x+5,this.y+60,this.hp*0.3,6);
        ctx.strokeRect(this.x+5,this.y+60,this.hp*0.3,6);
        ctx.drawImage();
        ctx.closePath();
    }
    moveL(){
        if (this.x>=0){
        this.x-=this.speed;
    }}
    moveR(){
        if (this.x<=750){
        this.x+=this.speed;
    }}
}
