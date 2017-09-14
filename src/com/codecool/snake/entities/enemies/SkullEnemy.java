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
        setX(50);
        setY(50);
        setImage(Globals.skullEnemy);
    }

    public void apply() {
        collisionHandler();
        if (getX() < 333) {
            setX(getX() + 300);
        } else {
            setX(getX() - 300);
        }
        if (getY() < 333) {
            setY(getY() + 300);
        } else {
            setY(getY() - 300);
        }
    }

    public void apply(SnakeHead player){
        this.music("oh_man.wav", 2);
        player.gameOver();
    }


    public void step(){
        super.step();
    }

}
