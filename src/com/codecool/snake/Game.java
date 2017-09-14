package com.codecool.snake;

import com.codecool.snake.entities.enemies.HeadEnemy;
import com.codecool.snake.entities.enemies.UnicornEnemy;
import com.codecool.snake.entities.enemies.SkullEnemy;
import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
                    dialogVbox.getChildren().add(new Button("RESUME!44!"));
                    dialogVbox.getChildren().add(new Button("RESTART!!4"));
                    dialogVbox.getChildren().add(new Button("BYE"));
                    Scene dialogScene = new Scene(dialogVbox, 500, 350);
                    dialog.setScene(dialogScene);
                    dialog.show();
            }
        });

        scene.setOnMouseClicked(event -> {
            switch (event.getButton()) {
                case PRIMARY:
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
