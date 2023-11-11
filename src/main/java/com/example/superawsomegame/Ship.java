package com.example.superawsomegame;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class Ship extends Taz implements Controllable{
    private boolean shoot=false;
    private int timer=0;
    Ship(double x, double y, double w, double h) {
        super(x, y, w, h);
        this.color="green";
    }
    @Override
    public void setInputs(KeyEvent e) {
        switch (e.getCode()) {
            case W -> up=true;
            case D -> right=true;
            case S -> down=true;
            case A -> left=true;
            case UP -> up=true;
            case RIGHT -> right=true;
            case DOWN -> down=true;
            case LEFT -> left=true;
            case SPACE -> shoot=true;
        }
    }

    @Override
    public void unSetInputs(KeyEvent e) {
        switch (e.getCode()){
            case W -> up=false;
            case D -> right=false;
            case S -> down=false;
            case A -> left=false;
            case UP -> up=false;
            case RIGHT -> right=false;
            case DOWN -> down=false;
            case LEFT -> left=false;
            case SPACE -> shoot=false;
        }
    }

    @Override
    public void bindToScene(Scene scene) {
        scene.setOnKeyReleased(this::unSetInputs);
        scene.setOnKeyPressed(this::setInputs);
    }
    private boolean runTimer(){
        if (timer<1){
            return true;
        }
        timer--;
        return false;
    }
    @Override
    public void toDo(){
        super.toDo();
        runTimer();
        if (shoot){
            if (runTimer()){
            Main.mainController.world.addGameObject(new Laser(x+width/2,y+height/2,10,20,this.rotation));
            timer=100;
            }
        }
        ArrayList<GameObject> gameObjects = Main.mainController.world.gameObjects;
        for (int i=0;i<gameObjects.size();i++){
            if (Collision.object_collision(this,gameObjects.get(i),0,0)){

                if  (gameObjects.get(i).id==1){
                    Main.mainController.world.reset();
                }
            }
        }
    }
}
