package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class CurrentMap {
    public static List<List<String>> currentMap() {

        List<String> oneLine = new ArrayList<>();
        List<String> twoLine = new ArrayList<>();
        List<String> threeLine = new ArrayList<>();
        List<String> fourLine = new ArrayList<>();
        List<String> fiveLine = new ArrayList<>();
        List<List<String>> map = new ArrayList<>();


        map.add(oneLine);
        map.add(twoLine);
        map.add(threeLine);
        map.add(fourLine);
        map.add(fiveLine);


        for(List<String> holdingArray : map){
            for(int i = 0; i <= 7; i++){
                holdingArray.add(", ");
            }
        }

        map.get(2).set(3, "@ ");
        map.get(1).set(1, "G ");
        map.get(3).set(5, "K ");
        map.get(4).set(2, "E ");


        return map;
    }

}
