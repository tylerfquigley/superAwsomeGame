package com.example.superawsomegame;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

import java.util.ConcurrentModificationException;

import static java.lang.System.currentTimeMillis;

public class MainController implements Runnable{
private GraphicsContext gc;
protected World world;
private boolean run = false;
private Thread mainThread;
private AnimationTimer animationTimer;
    @FXML
    Canvas canvas1;
    @FXML
    public void initialize(){
        gc = canvas1.getGraphicsContext2D();
        world = World.getWorld();
        canvas1.setHeight(500);
        canvas1.setWidth(500);
        mainThread = new Thread(this);
        mainThread.start();
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.setFill(Paint.valueOf("black"));
                gc.fillRect(0,0,canvas1.getWidth(),canvas1.getHeight());
                for (GameObject gameObject : world.gameObjects) {
                    try {
                        gameObject.render(gc);
                    }catch (ConcurrentModificationException e){
                        //ignore
                    }

                }


            }
        };
        animationTimer.start();
    }

    @Override
    public void run() {
        run=true;
        long c;
        long s = currentTimeMillis();
        while(run){
            c= currentTimeMillis();
            if((c-s)>(1000/world.getFrameRate())){
                c = currentTimeMillis();
                s = currentTimeMillis();
                try {
                    for (GameObject gameObject : world.gameObjects) {
                        gameObject.toDo();
                        if (gameObject.delete){
                            gameObject.onDelete();
                            world.gameObjects.remove(gameObject);
                        }

                    }}catch (ConcurrentModificationException e){

                }
                }
        }
    }
    protected void endProgram(){
        if(world!=null){this.run=false;
        System.out.println("killing world thread");

        }
    }
    protected void spawn(GameObject gameObject){
    }
}