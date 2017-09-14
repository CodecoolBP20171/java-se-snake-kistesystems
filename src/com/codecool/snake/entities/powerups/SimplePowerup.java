package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

import java.util.Random;

// a simple powerup that makes the snake grow TODO make other powerups
public class SimplePowerup extends GameEntity implements Interactable {

    public SimplePowerup(Pane pane) {
        super(pane);
        setImage(Globals.morty);
        pane.getChildren().add(this);

        Random rnd = new Random();
        double x = rnd.nextDouble() * Globals.WINDOW_WIDTH;
        double y = rnd.nextDouble() * Globals.WINDOW_HEIGHT;
        if (x < 50) {
            x += 50;
        } else if (x > (Globals.WINDOW_WIDTH - 50)){
            x -= 50;
        }

        if (y < 50) {
            y += 50;
        } else if (y > (Globals.WINDOW_HEIGHT - 50)){
            y -= 50;
        }

        setX(x);
        setY(y);
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.addPart(4);
        destroy();
        snakeHead.changeScore(10);
    }

    @Override
    public String getMessage() {
        return "Got power-up :)";
    }
}
