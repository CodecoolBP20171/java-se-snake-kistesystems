package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import javafx.scene.layout.Pane;

public class KamikazeEnemy extends SimpleEnemy {

    public KamikazeEnemy(Pane pane){
        super(pane);
        setImage(Globals.kamikazeEnemy);
    }


    public void apply() {
        destroy();
    }
}
