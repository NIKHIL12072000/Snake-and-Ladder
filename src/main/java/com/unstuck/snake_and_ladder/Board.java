package com.unstuck.snake_and_ladder;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {

    public HashMap<Integer,Integer> map;
    Board(){
        map=new HashMap<>();
        map.put(4,25);
        map.put(13,46);
        map.put(27,5);
        map.put(33,49);
        map.put(40,3);
        map.put(42,63);
        map.put(43,18);
        map.put(50,69);
        map.put(54,31);
        map.put(62,81);
        map.put(66,45);
        map.put(74,92);
        map.put(76,58);
        map.put(89,53);
        map.put(99,41);
        populatePositionCordinates();
    }
    ArrayList<Pair<Integer,Integer>> positionCordinates;
    private void populatePositionCordinates(){
        positionCordinates=new ArrayList<>();
        int x=1,y=10,xPos,yPos;
        for(int i=0;i<SnakeAndLadder.height;i++){
            if(y%2==0) x=1;
            else x=10;
            for(int j=0;j<SnakeAndLadder.width;j++){
                xPos=x*SnakeAndLadder.tile_size-SnakeAndLadder.tile_size/2;
                yPos=y*SnakeAndLadder.tile_size-SnakeAndLadder.tile_size/2;
                positionCordinates.add(new Pair<>(xPos,yPos));
                if(y%2==0) x++;
                else x--;
            }
            y--;
        }
    }

    public int getXCoordinate(int x){
        return positionCordinates.get(x-1).getKey();
    }

    public int getYCoordinate(int y){
        return positionCordinates.get(y-1).getValue();
    }

    public static void main(String args[]){
        int i=1;
        for(Pair<Integer,Integer> pair: new Board().positionCordinates) {
            System.out.println(i + " " + pair.getKey() + " " + pair.getValue());
            i++;
        }
    }
}
