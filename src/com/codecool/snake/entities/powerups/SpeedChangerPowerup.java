package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

import java.util.Random;

public class SpeedChangerPowerup extends SimplePowerup implements Interactable {
    public SpeedChangerPowerup(Pane pane) {
        super(pane);
        setImage(Globals.speedChanger);
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.changeSpeed();
        destroy();
        snakeHead.changeScore(50);
        this.music("speed.wav",10.0f);
        new SpeedChangerPowerup(pane);
    }

    @Override
    public String getMessage() {
        return "Speed changed";
    }
}
