package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Places {

    public static Map<String, String> load() {
        Map<String, String> placesList = new HashMap<>();
        placesList.put(", ","You're at the zoo! Around you, attractions and people bustle with noise");
        placesList.put("G ","The gorilla eyeballs you from his enclosure. He scratches his butt, menacingly");
        placesList.put("E ", "The elephant's long trunk trunk wraps around an ice cream cone. He holds it out to offer you a lick");
        placesList.put("K ", "The kangaroo leans in towards you and whispers \"G'day mate\" before hopping away");
        //placesList.put("head","walk");
        return placesList;
    }
}
