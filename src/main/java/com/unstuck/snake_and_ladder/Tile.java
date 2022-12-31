package com.unstuck.snake_and_ladder;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    public Tile(int size){
        setWidth(size);
        setHeight(size);
        setFill(Color.YELLOW);
        setStroke(Color.BLACK);
    }
}
