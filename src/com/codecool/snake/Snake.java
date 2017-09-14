package com.codecool.snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class Snake extends Application {

    private static MediaPlayer mediaPlayer;
    public void backgroundMusic(){
        Media sound = new Media(new File("BackGround.mp3").toURI().toString());
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

        backgroundMusic();

        Scene scene = new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);
        scene.setFill(Color.GRAY);

        BackgroundImage myBI= new BackgroundImage(new Image("Space.jpg",Globals.WINDOW_WIDTH,Globals.WINDOW_HEIGHT,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        //then you set to your node
        game.setBackground(new Background(myBI));

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        game.start();
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}
