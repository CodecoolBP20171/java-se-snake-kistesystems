package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class UnicornEnemy extends SimpleEnemy {
    private int stepX;
    private int stepY;
    private double playerX;
    private double playerY;
    double distanceY;
    double distanceX;



    public UnicornEnemy(Pane pane){
        super(pane);
        setImage(Globals.unicornEnemy);
    }


    public void getPlayerPosition(){
        for (GameEntity entity : Globals.getGameObjects()) {
            if (entity instanceof SnakeHead) {
                this.playerX = entity.getX();
                this.playerY = entity.getY();
            }
        }
    }


    public void facePlayer(){
        getPlayerPosition();
        boolean aimX = (playerX > this.getX());
        boolean aimY = (playerY > this.getY());
        boolean equalX = (playerX == this.getX());
        boolean equalY = (playerY == this.getY());

        setRotate(Math.toDegrees(Math.atan2(playerY-this.getY(), playerX-this.getX())) + 90);

        /*
        if (equalX && aimY){
            setRotate(0);
        } else if (equalX && !aimY) {
            setRotate(180);
        } else if (equalY && aimX) {
            setRotate(90);
        } else if (equalY && !aimX) {
            setRotate(270);
        } else if (aimX && !aimY){
            setRotate(45);
        } else if (aimX && aimY){
            setRotate(135);
        } else if (!aimX && aimY){
            setRotate(225);
        } else if (!aimX && !aimY) {
            setRotate(315);
        }*/
    }

    public void moveTowardsPlayer(){
        getPlayerPosition();

        if (playerX > this.getX()) {
            stepX = 1;
        } else if (playerX < this.getX()) {
            stepX = -1;
        } else {
            stepX = 0;
        }

        if (playerY > this.getY()) {
            stepY = 1;

        } else if (playerY < this.getY()) {
            stepY = -1;
        } else {
            stepY = 0;
        }

        setX(getX() + stepX);
        setY(getY() + stepY);
        facePlayer();
    }



    public void step() {
        if (isOutOfBounds()) {
            collisionHandler();
        }
        moveTowardsPlayer();
    }

    public void apply() {
        this.music("aids.wav", 1);
        destroy();
    }
}
