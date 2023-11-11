package com.example.superawsomegame;

public class SpaceRock extends Taz{
    SpaceRock(int x, int y, int w, int h) {
        super(x, y, w, h);
        this.id=1;
        speed=2;
    }
    @Override
    protected  void toDo(){
        if (x<(0-width/2)){
            x=500+width/2;
        }
        if (y<(0-height/2)){
            y=500+height/2;
        }
        if (x>(501+width/2)){
            x=1-width/2;
        }
        if (y>(501+height/2)){
            y=1-height/2;
        }
        rotation+=.1;
        double angle=Math.toRadians(rotation);
        hsp=Math.sin(angle)*speed;
        vsp=Math.cos(angle)*speed;
        x-=hsp;
        y+=vsp;
    }
}
