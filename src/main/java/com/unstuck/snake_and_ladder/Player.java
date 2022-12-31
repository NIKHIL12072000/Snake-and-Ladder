package com.unstuck.snake_and_ladder;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.function.BiPredicate;

public class Player {

    private Circle coin;
    private int coinPosition;

    public static Board board=new Board();

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public Player(int tileSize, Color coinColor, String name){
        coinPosition=1;
        this.name=name;
        coin=new Circle(tileSize/2);
        coin.setFill(coinColor);
        coin.setStroke(Color.BLACK);
        coin.setTranslateX(35);
        coin.setTranslateY(665);
    }

    public Circle setCoin(int x, int y){
        coin.setTranslateX(x);
        coin.setTranslateY(y);
        return this.coin;
    }

    public Circle getCoin(){
        return  coin;
    }

    public int getCoinPosition(){
        return coinPosition;
    }

    public void setCoinPosition(int coinPosition) {
        this.coinPosition = coinPosition;
    }

    public void movePlayer(int diceValue){
        if(coinPosition+diceValue<=100){
            coinPosition+=diceValue;
            if(board.map.containsKey(coinPosition)) {
                translatePlayer();
                coinPosition=board.map.get(coinPosition);
                translatePlayer();
            }
            else{
               translatePlayer();
            }
        }
    }

    public void translatePlayer(){
        TranslateTransition move=new TranslateTransition(Duration.millis(1000),this.coin);
        move.setToX(board.getXCoordinate(coinPosition));
        move.setToY(board.getYCoordinate(coinPosition));
        move.setAutoReverse(false);
        move.play();
    }

}
