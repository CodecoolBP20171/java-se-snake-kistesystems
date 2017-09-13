package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Animatable;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Dialog;
import javafx.stage.PopupWindow;
import javafx.stage.Window;

import java.awt.*;

public class GameLoop extends AnimationTimer {

    // This gets called every 1/60 seconds
    @Override
    public void handle(long now) {
        for (GameEntity gameObject : Globals.gameObjects) {
            if (gameObject instanceof Animatable) {
                Animatable animObject = (Animatable) gameObject;
                animObject.step();
            }
        }
        Globals.gameObjects.addAll(Globals.newGameObjects);
        Globals.newGameObjects.clear();

        Globals.gameObjects.removeAll(Globals.oldGameObjects);
        Globals.oldGameObjects.clear();

        if (Globals.pKeyPressed) {
            Globals.gameLoop.stop();
            Dialog popUp = new Dialog();
            popUp.initOwner(Snake.getPrimaryStageRef());
            popUp.showAndWait();
            Globals.pKeyPressed = false;
        }
    }
}

