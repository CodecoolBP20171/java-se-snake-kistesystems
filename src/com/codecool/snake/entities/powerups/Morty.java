package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class Morty extends SimplePowerup {
    public Morty(Pane pane){
        super(pane);
    }
    public void apply(SnakeHead snakeHead){
        super.apply(snakeHead);
        this.music("wubba.wav", 1);
        new Morty(pane);
    }
}
