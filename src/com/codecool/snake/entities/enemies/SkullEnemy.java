package com.codecool.snake.entities.enemies;


import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.Random;

public class SkullEnemy extends SimpleEnemy{

    public SkullEnemy(Pane pane){
        super(pane);
        setImage(Globals.skullEnemy);
    }

    public void apply(SnakeHead player){
        player.gameOver();
    }


    public void step(){
        super.step();
    }

}
