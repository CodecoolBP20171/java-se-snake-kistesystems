package com.codecool.snake;

import javafx.application.Application;
import javafx.scene.Scene;
-import javafx.scene.image.Image;
-import javafx.scene.layout.*;
-import javafx.scene.media.Media;
-import javafx.scene.media.MediaPlayer;
-import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Snake extends Application {

    private static Stage primaryStageRef;


    MediaPlayer mediaPlayer;
    public void backgroundMusic(String musicFile){
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaPlayer.seek(Duration.seconds(30.3f));
            }
        });
        mediaPlayer.setStartTime(Duration.seconds(3.3f));
        mediaPlayer.setVolume(0.2f);
        mediaPlayer.play();
    }

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
