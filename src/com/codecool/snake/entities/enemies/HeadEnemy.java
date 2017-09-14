package com.codecool.snake.entities.enemies;

import javafx.scene.layout.Pane;

public class HeadEnemy extends SimpleEnemy {
    public HeadEnemy(Pane pane){
        super(pane);
    }



    public void apply(){
        collisionHandler();
        this.music("HeadNotCool.mp3", 1.5);
    }
}
