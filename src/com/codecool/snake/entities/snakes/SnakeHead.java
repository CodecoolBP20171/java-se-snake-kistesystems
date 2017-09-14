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
import com.codecool.snake.entities.powerups.SimplePowerup;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class SnakeHead extends GameEntity implements Animatable {

    private static final float speed = 2;
    private static final float turnRate = 2;
    private GameEntity tail; // the last element. Needed to know where to add the next part.
    private int health;

    public SnakeHead(Pane pane, int xc, int yc) {
        super(pane);
        setX(xc);
        setY(yc);
        health = 100;
        tail = this;
        setImage(Globals.snakeHead);
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
                if (entity instanceof SimplePowerup) {
                    this.music("wubba.wav", 1);
                } else if (entity instanceof HeadEnemy) {
                    this.music("HeadDestroy.mp3", 10.0);
                } else if (entity instanceof SkullEnemy){
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

    public void destroyEveryEntity(){
        for (GameEntity entity : Globals.getGameObjects()) {
            entity.destroy();
        }
    }

    public void gameOver(){
        System.out.println("Game Over");
        Snake.getMediaPlayer().pause();
        music("GameOver.mp3", 10.0f);
        destroyEveryEntity();
        Globals.gameLoop.stop();
        JOptionPane.showMessageDialog(null, "Oh geez Rick, you dead", "GAME OVER", -1);
    }


    public void addPart(int numParts) {
        for (int i = 0; i < numParts; i++) {
            SnakeBody newPart = new SnakeBody(pane, tail);
            tail = newPart;
        }
    }

    public void changeHealth(int diff) {
        health += diff;
    }
}
