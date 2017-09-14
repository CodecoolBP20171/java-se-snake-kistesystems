package com.codecool.snake;

import com.codecool.snake.entities.enemies.HeadEnemy;
import com.codecool.snake.entities.enemies.UnicornEnemy;
import com.codecool.snake.entities.enemies.SkullEnemy;
import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;

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
        new SimplePowerup(this);
        new SimplePowerup(this);
        new SimplePowerup(this);


    }


    public void start() {
        Button resume = new Button("RESUME!!44!");
        Button restart = new Button("RESTART!!4");
        Button exit = new Button("BYE");
        Scene scene = getScene();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = true; break;
                case RIGHT: Globals.rightKeyDown  = true; break;
                case P: Globals.pKeyPressed = true;
                    final Stage dialog = new Stage();
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    dialog.initOwner(scene.getWindow());
                    VBox dialogVbox = new VBox(20);
                    dialogVbox.getChildren().add(new Text("What we gonna do Rick?"));
                    dialogVbox.getChildren().add(resume);
                    dialogVbox.getChildren().add(restart);
                    dialogVbox.getChildren().add(exit);
                    Scene dialogScene = new Scene(dialogVbox, 500, 350);
                    dialog.setScene(dialogScene);
                    dialog.show();
                    resume.setOnMouseClicked(event1 -> {
                        Globals.getGameObjects();
                        Globals.pKeyPressed = false;
                        start();
                    });
                    restart.setOnMouseClicked(event1 -> {
                        Globals.gameObjects.clear();
                    });
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
