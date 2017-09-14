package com.codecool.snake;

import com.codecool.snake.entities.enemies.HeadEnemy;
import com.codecool.snake.entities.enemies.UnicornEnemy;
import com.codecool.snake.entities.enemies.SkullEnemy;
import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.powerups.SpeedChangerPowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Game extends Pane {

    public Game() {
        new SnakeHead(this, 500, 500);

        new HeadEnemy(this);
        new HeadEnemy(this);
        new HeadEnemy(this);
        new HeadEnemy(this);

        new UnicornEnemy(this);
        new UnicornEnemy(this);
        new UnicornEnemy(this);
        new UnicornEnemy(this);

        new SkullEnemy(this);

        new SimplePowerup(this);
        new SpeedChangerPowerup(this);


    }



    public void start() {
        Scene scene = getScene();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = true; break;
                case RIGHT: Globals.rightKeyDown  = true; break;
                case P: Globals.pKeyPressed = true;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = false; break;
                case RIGHT: Globals.rightKeyDown  = false; break;
            }
        });
        Globals.gameLoop = new GameLoop();
        Globals.gameLoop.start();
    }
}
