package com.codecool.snake.entities.snakes;

import com.codecool.snake.Snake;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.enemies.HeadEnemy;
import com.codecool.snake.entities.enemies.SkullEnemy;
import com.codecool.snake.entities.enemies.UnicornEnemy;
import com.codecool.snake.entities.powerups.Morty;
import com.codecool.snake.entities.powerups.SimplePowerup;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import javax.swing.*;
import java.io.File;
import java.util.Random;
import javafx.scene.paint.Color;

public class SnakeHead extends GameEntity implements Animatable {

    private static int speed = 2;
    private static final float turnRate = 2;
    private GameEntity tail; // the last element. Needed to know where to add the next part.
    private int health;
    private int score;
    Text textHealth = new Text();
    Text textScore = new Text();

    public SnakeHead(Pane pane, int xc, int yc) {
        super(pane);
        setX(xc);
        setY(yc);
        health = 100;
        score = 0;
        tail = this;
        setImage(Globals.snakeHead);

        String newText = "Health: " + String.valueOf(health);
        textHealth.setText(newText);
        textHealth.setX(50);
        textHealth.setY(50);
        textHealth.setFill(Color.YELLOW);
        textHealth.setFont(new Font(20));
        pane.getChildren().add(textHealth);

        String newTextScore = "Score: " + String.valueOf(score);
        textScore.setText(newTextScore);
        textScore.setX(50);
        textScore.setY(70);
        textScore.setFill(Color.YELLOW);
        textScore.setFont(new Font(20));
        pane.getChildren().add(textScore);


        pane.getChildren().add(this);

        addPart(4);
    }


    public void step() {
        double dir = getRotate();
        if (Globals.leftKeyDown) {
            dir = dir - turnRate;
        }
        if (Globals.rightKeyDown) {
            dir = dir + turnRate;
        }
        // set rotation and position
        setRotate(dir);
        Point2D heading = Utils.directionToVector(dir, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
        // check if collided with an enemy or a powerup
        for (GameEntity entity : Globals.getGameObjects()) {
            if (getBoundsInParent().intersects(entity.getBoundsInParent())) {
                if (entity instanceof Interactable) {
                    Interactable interactable = (Interactable) entity;
                    interactable.apply(this);
                    System.out.println(interactable.getMessage());
                }
                if (entity instanceof Morty) {
                    this.music("wubba.wav", 1);
                } else if (entity instanceof HeadEnemy) {
                    this.music("HeadDestroy.mp3", 10.0);
                } else if (entity instanceof SkullEnemy) {
                    this.music("oh_man.wav", 2);
                } else if (entity instanceof UnicornEnemy) {
                    this.music("aids.wav", 1);
                }
            }
        }

        // check for game over condition
        if (isOutOfBounds() || health <= 0) {
            gameOver();
        }
    }

    public void destroyEveryEntity() {
        for (GameEntity entity : Globals.getGameObjects()) {
            entity.destroy();
        }
    }

    MediaPlayer mediaPlayer;

    public void music(String musicFile, double volume, double startTimeInSeconds) {
        if (mediaPlayer == null) {
            MediaPlayer mediaPlayer;
        }
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setStartTime(Duration.seconds(startTimeInSeconds));

        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
        mediaPlayer.setOnPlaying(new Runnable() {
            public void run() {
                pane.getChildren().add(addText("Oh geez, Rick is dead!", 250, 200));
                pane.getChildren().add(addText("Your score is "+ String.valueOf(score), 280, 400));
            }
        });
    }

    public void gameOver() {
        System.out.println("Game Over");
        Snake.getMediaPlayer().pause();
        music("GameOver.mp3", 10.0f, 10.0f);
        destroyEveryEntity();
        Globals.gameLoop.stop();
        pane.getChildren().add(addText("GAME OVER", 300, 300));
        //JOptionPane.showMessageDialog(null, "Oh geez Rick, you dead", "GAME OVER", -1);
    }


    public void addPart(int numParts) {
        for (int i = 0; i < numParts; i++) {
            SnakeBody newPart = new SnakeBody(pane, tail);
            tail = newPart;
        }
    }

    public Text addText(String textBody, int x, int y) {
        Text text = new Text();
        String newText = textBody;
        text.setText(newText);
        text.setX(x);
        text.setY(y);
        text.setFill(Color.YELLOW);
        text.setFont(new Font(50));
        return text;
    }

    public void setTextHealth(int health) {
        this.textHealth.setText("Health: " + String.valueOf(health));
    }

    public void setTextScore(int score) {
        this.textScore.setText("Score: " + String.valueOf(score));
    }

    public void changeHealth(int diff) {
        health += diff;
        setTextHealth(health);
    }

    public void changeScore(int diff) {
        score += diff;
        setTextScore(score);
    }

    public void changeSpeed() {
        Random rnd = new Random();
        speed = rnd.nextInt(5 - 1 + 1) + 1;
    }
}
