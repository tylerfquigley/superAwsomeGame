package com.example.superawsomegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
   protected static MainController mainController;
    protected static Scene  scene;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
         mainController = new MainController();
       fxmlLoader.setController(mainController);
        scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        startLevel();
        stage.setOnCloseRequest(windowEvent -> {
mainController.endProgram();
        });
    }

    public static void main(String[] args) {
        launch();
    }
    protected static void startLevel(){
        Ship s = new Ship(50,50,25,25);
        s.addPoint(0,0);
        s.addPoint(12.5,10);
        s.addPoint(25,0);
        s.addPoint(12.5,25);
        mainController.world.addGameObject(s);
        s.bindToScene(scene);
        SpaceRock rock1 = new SpaceRock(250,250,50,50,1);

        mainController.world.addGameObject(rock1);
    }
}