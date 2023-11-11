package com.example.superawsomegame;

import java.util.ArrayList;

import static java.lang.System.currentTimeMillis;

public class World{
    private static World world;
    protected ArrayList<GameObject> gameObjects;


    private final int frameRate=120;
    private World(){
        gameObjects = new ArrayList<GameObject>();
    }


    protected static World getWorld(){
        if (world==null){
            world = new World();
        }
        return world;
    }
  protected void addGameObject(GameObject gameObject){
        gameObjects.add(gameObject);
  }
protected int getFrameRate(){
        return this.frameRate;
}
}
