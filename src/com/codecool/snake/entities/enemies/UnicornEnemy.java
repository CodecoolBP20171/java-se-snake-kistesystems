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
        setRotate(Math.toDegrees(Math.atan2(playerY-this.getY(), playerX-this.getX())) + 90);
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
