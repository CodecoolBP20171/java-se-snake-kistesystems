package com.codecool.snake.entities.enemies;


import com.codecool.snake.Utils;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.Random;

public class CirculatingEnemy extends SimpleEnemy{
    private Point2D heading;
    private final int damage = 20;
    private double direction;

    public CirculatingEnemy(Pane pane){
        super(pane);
    }

    public void followRandomPath() {
        int speed = 2;
        Random rnd = new Random();
        double direction = rnd.nextDouble() * 360;
        setRotate(direction);
        this.heading = Utils.directionToVector(direction, speed);
    }

    @Override
    public void step(){
        followRandomPath();
        super.step();
    }

}
