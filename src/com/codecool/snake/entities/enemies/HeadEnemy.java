package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class HeadEnemy extends SimpleEnemy {
    public HeadEnemy(Pane pane){
        super(pane);
    }



    public void apply(){
        collisionHandler();
        if (getX() < 333) {
            setX(getX()+300);
        } else {
            setX(getX()-300);
        }
        if (getY() < 333) {
            setY(getY()+300);
        } else {
            setY(getY()-300);
        }
        this.music("HeadNotCool.mp3", 1.5);
    }

    public void apply(SnakeHead player) {
        super.apply(player);
        this.music("HeadDestroy.mp3", 10.0);
        new HeadEnemy(pane);

    }
}
