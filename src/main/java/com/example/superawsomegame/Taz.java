package com.example.superawsomegame;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import java.util.ArrayList;


public class Taz extends SolidObject{
    protected double decel=.99;
    protected double rotation=0;
    protected double speed=0;
    private double acel=.1;
    protected double hsp=0;
    protected double vsp=0;
    protected boolean right;
  protected boolean left;
    protected boolean up;
    protected boolean down;
private ArrayList<Cord> points;
    Taz(double x, double y, double w, double h) {
        super(x, y, w, h);
        points=new ArrayList<Cord>();
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

        speed=0;
        vsp=vsp*decel;
        hsp=hsp*decel;
        if (right&&!left){rotation+=5;}
        if (!right&&left){rotation-=5;}
        if (up&&!down){speed=acel;}
        if (!up&&down){speed=-acel;}
        double angle=Math.toRadians(rotation);
        hsp+=Math.sin(angle)*speed;
        vsp+=Math.cos(angle)*speed;
        x-=hsp;
        y+=vsp;
    }
    @Override
    public void render(GraphicsContext gc){
      double[] xPoints= new double[points.size()];
      double[] yPoints= new double[points.size()];
      double centX=width/2;
      double centY=height/2;
      double angle = Math.toRadians(rotation);
      double cos =Math.cos(angle);
      double sin =Math.sin(angle);
      for (int i=0;i<points.size();i++){
          double x0= points.get(i).x;
          double y0= points.get(i).y;
          double x1= (((x0-centX)*cos)-(sin*(y0-centY))+centX);
          double y1= (((x0-centX)*sin)+(cos*(y0-centY))+centY);
          xPoints[i]=x1+x;
          yPoints[i]=y1+y;
      }
        gc.setStroke(Paint.valueOf("white"));
        gc.strokePolygon(xPoints,yPoints, points.size());
    }
    public void addPoint(double x,double y){
        points.add(new Cord(x,y));
    }



    private class Cord{
        double x;
        double y;
        Cord(double x,double y){
            this.x=x;
            this.y=y;
        }
    }
}
