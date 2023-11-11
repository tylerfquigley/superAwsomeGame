package com.example.superawsomegame;

public class Collision {
    //static collision detection methods
    //check if 2 objects are collideing
    static boolean object_collision(GameObject o1,GameObject o2,float xOff,float yOff){
        double x1=o1.x;
        double w1 =o1.width;
        double h1 = o1.height;
        double y1=o1.y;
        boolean c=false;
        for(int i=(int) (x1-w1/2+xOff);i<=x1+w1/2+xOff;i++){
            for(int j= (int) (y1-h1/2+yOff);j<=y1+h1/2+yOff;j++){
                if(point_collision(i,j,o2)){c=true;break;}
            }
            if (c){break;}
        }


        return c;
    }
    //check if a point is collideing with an object
    static boolean point_collision(float x,float y,GameObject o){
        boolean c =false;
       double x1=o.x;
        double w1 =o.width;
        double h1 = o.height;
       double y1=o.y;
        if ((x>=x1-w1/2)&&(x<=x1+w1/2)&&(y>=y1-h1/2)&&(y<=y1+h1/2)){c=true;}
        return c;
    }
}


