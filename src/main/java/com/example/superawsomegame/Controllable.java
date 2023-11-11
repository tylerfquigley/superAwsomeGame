package com.example.superawsomegame;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public interface Controllable {
    void setInputs(KeyEvent e);
    void unSetInputs(KeyEvent e);

    void bindToScene(Scene scene);
}
