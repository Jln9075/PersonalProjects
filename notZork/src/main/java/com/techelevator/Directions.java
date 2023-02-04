package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Directions {
    
public static final int NORTH = 0;
public static final int EAST = 1;
public static final int SOUTH = 2;
public static final int WEST = 3;



    public static Map<String, Integer> load() {
        Map<String, Integer> directionsList = new HashMap<>();
        directionsList.put("north", NORTH);
        directionsList.put("east", EAST);
        directionsList.put("south", SOUTH);
        directionsList.put("west", WEST);
        return directionsList;
    }
}