package com.unstuck.snake_and_ladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class SnakeAndLadder extends Application {

    public static final int tile_size=70, height=10, width=10, lower_line=tile_size*height+10;
    public Label label1,label2;
    Player player1=new Player(tile_size-10, Color.WHITE,"Nikhil");
    Player player2=new Player(tile_size/2,Color.BLACK,"Mrunal Thakur");
    Button playagain=new Button("Play Again ?");
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Let's Play Snake and Ladder");
        stage.setScene(scene);
        stage.show();
    }
    public Pane createContent(){
        Pane root=new Pane();

        Tile tile=new Tile(tile_size);
        root.setMinSize(width*tile_size, height*tile_size+50);
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                tile.setTranslateX(j*tile_size);
                tile.setTranslateY(i*tile_size);
                root.getChildren().add(tile);
                tile=new Tile(tile_size);
            }
        }
        Image image=new Image("C:\\Users\\Nikhil\\IdeaProjects\\Snake And Ladder\\src\\main\\resources\\board.png");
        ImageView board=new ImageView();
        board.setImage(image);
        board.setFitWidth(tile_size*width);
        board.setFitHeight(tile_size*height);
        root.getChildren().add(board);

        Button button1=new Button("Player One");
        Button button2=new Button("Player Two");
        Random dice=new Random();
        label1=new Label("Throw Dice");
        label2=new Label(" ");

        playagain.setVisible(false);
        playagain.setTranslateY(lower_line+5);
        playagain.setTranslateX(400);
        playagain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                player1.setCoinPosition(1);
                player2.setCoinPosition(1);
                player1.setCoin(35,665);
                player2.setCoin(35,665);
                playagain.setVisible(false);
                button1.setVisible(true);
                button1.setDisable(false);
                button2.setVisible(true);
                button2.setDisable(true);
                label1.setVisible(true);
                label1.setText("Throw Dice");
                label2.setVisible(true);
            }
        });

        button1.setTranslateX(20);
        button1.setTranslateY(lower_line);
        label1.setTranslateY(lower_line+5);
        label1.setTranslateX(100);
        button2.setDisable(true);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                button2.setDisable(false);
                button1.setDisable(true);
                int diceValue=dice.nextInt(6)+1;
                player1.movePlayer(diceValue);
                if(player1.getCoinPosition()<94)label1.setText("Dice: "+diceValue+" and You are at: "+player1.getCoinPosition());
                else if(player1.getCoinPosition()==100) {
                    button1.setVisible(false);
                    button2.setVisible(false);
                    label2.setVisible(false);
                    label1.setVisible(true);
                    label1.setText("Congratulations, Player 1 has Won the Game !!!");
                    playagain.setVisible(true);
                }
                else {
                    label1.setText("You are at: " + player1.getCoinPosition() + " require " + (100 - player1.getCoinPosition()));
                    if (player2.getCoinPosition() < 94) label2.setText("Throw dice");
                    else label2.setText("Throw dice of value " + (100 - player2.getCoinPosition()) + " to Win");
                }
            }
        });


        button2.setTranslateX(300);
        button2.setTranslateY(lower_line);
        label2.setTranslateY(lower_line+5);
        label2.setTranslateX(400);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                button1.setDisable(false);
                button2.setDisable(true);
                int diceValue=dice.nextInt(6)+1;
                label2.setText(""+diceValue);
                player2.movePlayer(diceValue);
                if(player2.getCoinPosition()<94)label2.setText("Dice: "+diceValue+" and You are at: "+player2.getCoinPosition());
                else if(player2.getCoinPosition()==100) {
                    button1.setVisible(false);
                    button2.setVisible(false);
                    label2.setVisible(false);
                    label1.setVisible(true);
                    label1.setText("Congratulations, Player 2 has Won the Game !!!");
                    playagain.setVisible(true);
                }
                else {
                    label2.setText("You are at: " + player2.getCoinPosition() + " require " + (100 - player2.getCoinPosition()));
                    if (player1.getCoinPosition() < 94) label1.setText("Throw dice");
                    else label1.setText("Throw dice of value " + (100 - player1.getCoinPosition()) + " to Win");
                }
            }
        });

        root.getChildren().addAll(button1,label1,button2, label2,player1.getCoin(),player2.getCoin(),playagain);
        return root;
    }
    public static void main(String[] args) {
        launch();
    }
}