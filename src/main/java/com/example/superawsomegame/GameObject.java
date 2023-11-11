package com.example.superawsomegame;

import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject {
    protected int id=0;
    protected boolean delete=false;
    protected double x;
    protected double y;
    protected double width;
    protected double height;

    protected abstract void toDo();

    protected abstract void render(GraphicsContext gc);

    protected abstract void onDelete();

}
