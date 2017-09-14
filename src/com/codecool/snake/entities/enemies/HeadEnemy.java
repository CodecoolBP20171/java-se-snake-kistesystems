package com.codecool.snake.entities.enemies;

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
}
