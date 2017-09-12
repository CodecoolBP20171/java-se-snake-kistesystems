package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeBody;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.Random;

// a simple enemy TODO make better ones.
public class SimpleEnemy extends GameEntity implements Animatable, Interactable {

    private Point2D heading;
    private static final int damage = 10;
    private int collisionCounter = 0;
    private double direction;


    public SimpleEnemy(Pane pane) {
        super(pane);

        setImage(Globals.simpleEnemy);
        pane.getChildren().add(this);
        int speed = 1;
        Random rnd = new Random();
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);

        this.direction = setDirection();
        setRotate(this.direction);
        heading = Utils.directionToVector(this.direction, speed);
    }

    public double setDirection() {
        Random rnd = new Random();
        return rnd.nextDouble() * 360;
    }

    public void collisionHandler(){
        int speed = 1;
        Random rnd = new Random();

        double direction = rnd.nextDouble() * 360;
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);
    }

    public boolean snakeBodyCollision(SnakeBody snakeBody){
        return ((getX() == snakeBody.getX()) && (getY() == snakeBody.getY()));
    }



    @Override
    public void step() {
        if (collisionCounter > 3) {
            destroy();
        }

        if (isOutOfBounds()) {
            collisionHandler();
            this.collisionCounter += 1;
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public void apply(SnakeHead player) {

        player.changeHealth(-damage);
        destroy();
    }

    public void apply(){
        collisionHandler();
    }

    @Override
    public String getMessage() {
        return "10 damage";
    }
}
