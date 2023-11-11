package com.example.superawsomegame;

public class SpaceRock extends Taz{
    protected double angularMomentum=.1;
    protected double scalar=1;
    SpaceRock(double x, double y, double w, double h,double scalar) {
        super(x, y, w, h);
        this.id=1;
        speed=2;
        this.scalar=scalar;
       addPoint(0*scalar,10*scalar);
       addPoint(20*scalar,0*scalar);
       addPoint(50*scalar,10*scalar);
       addPoint(45*scalar,25*scalar);
       addPoint(25*scalar,45*scalar);
       addPoint(0*scalar,50*scalar);
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
        rotation+=angularMomentum;
        double angle=Math.toRadians(rotation);
        hsp=Math.sin(angle)*speed;
        vsp=Math.cos(angle)*speed;
        x-=hsp;
        y+=vsp;
    }
    @Override
    protected void onDelete(){
        if (scalar>.25) {double newScalar= (scalar/2);
        //have baby rocks
        SpaceRock b1 = new SpaceRock(x-width/4,y-height/4,width/2,height/2,newScalar);
        SpaceRock b2 = new SpaceRock(x+width/4,y-height/4,width/2,height/2,newScalar);
        SpaceRock b3 = new SpaceRock(x-width/4,y+height/4,width/2,height/2,newScalar);
        SpaceRock b4 = new SpaceRock(x+width/4,y+height/4,width/2,height/2,newScalar);
        b1.rotation=-45;
        b2.rotation=45;
        b3.rotation=125;
        b4.rotation=150;
        Main.mainController.world.gameObjects.add(b1);
        Main.mainController.world.gameObjects.add(b2);
        Main.mainController.world.gameObjects.add(b3);
        Main.mainController.world.gameObjects.add(b4);
    }}
}
