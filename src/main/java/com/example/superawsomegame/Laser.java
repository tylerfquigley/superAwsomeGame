package com.example.superawsomegame;

import java.util.ArrayList;

public class Laser extends Taz{
    Laser(double x, double y, double w, double h, double rotation) {
        super(x, y, w, h);
        this.rotation=rotation;
        this.addPoint(0,0);
        this.addPoint(0,h);
        this.decel=1;
        this.color="teal";
    }
    @Override
    public void toDo(){
        if (x<(0-width/2)){
            delete=true;
        }
        if (y<(0-height/2)){
            delete=true;
        }
        if (x>(501+width/2)){
           delete=true;
        }
        if (y>(501+height/2)){
            delete=true;
        }

        speed=5;
        vsp=vsp*decel;
        hsp=hsp*decel;
        double angle=Math.toRadians(rotation);
        hsp=Math.sin(angle)*speed;
        vsp=Math.cos(angle)*speed;
        x-=hsp;
        y+=vsp;
        ArrayList<GameObject>gameObjects = Main.mainController.world.gameObjects;
        for (int i=0;i<gameObjects.size();i++){
            if (Collision.object_collision(this,gameObjects.get(i),0,0)){

              if  (gameObjects.get(i).id==1){
                  gameObjects.get(i).delete=true;
                  this.delete=true;
              }
            }
        }
    }
}
