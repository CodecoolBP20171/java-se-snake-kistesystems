package com.codecool.snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Snake extends Application {

    private static Stage primaryStageRef;

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();
        primaryStageRef = primaryStage;

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        primaryStage.show();
        game.start();
    }

    public static Stage getPrimaryStageRef() {
        return primaryStageRef;
    }

}
