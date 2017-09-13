package com.codecool.snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class Snake extends Application {
    MediaPlayer mediaPlayer;
    public void backgroundMusic(String musicFile){
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.2f);
        mediaPlayer.play();
    }
    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();

        backgroundMusic("BackGround.mp3");

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        primaryStage.show();
        game.start();
    }

}
