package com.example.superawsomegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class SolidObject extends GameObject{

    @Override
    protected void toDo() {

    }

    @Override
    protected void render(GraphicsContext gc) {
            double x1= x-(width/2);
            double x2= x+(width/2);
            double y1= y-(height/2);
            double y2= y+(height/2);
            gc.setStroke(Paint.valueOf("white"));
            gc.strokeRect(x1,y1,x2,y2);
    }
    SolidObject(double x, double y, double w, double h){
        this.x=x;
        this.y=y;
        this.width=w;
        this.height=h;


    }
}
