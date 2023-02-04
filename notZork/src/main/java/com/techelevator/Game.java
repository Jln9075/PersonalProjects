package com.techelevator;

import javax.swing.*;
import java.util.Map;
import java.util.Scanner;
import java.util.List;

import static com.techelevator.Directions.NORTH;
import static com.techelevator.Directions.EAST;
import static com.techelevator.Directions.WEST;
import static com.techelevator.Directions.SOUTH;

public class Game {
    private JFrame gui = new JFrame();
    int xCoordinate = 3;
    int yCoordinate = 2;
    String currentPlace = ", ";
    Map<String, String> placeEvent = Places.load();
    Map<String, Integer> cardinalDirections = Directions.load();
    List<List<String>> map = CurrentMap.currentMap();
    String userTextLowercase = "";
    private static Game game = new Game();
    private Scanner keyboard = new Scanner(System.in);


    public static void main(String[] args) {
        game.mainMenu();
    }

    private void printMap(){
        for(List<String> holdingArray : map) {
            for (int i = 0; i < holdingArray.size(); i++) {
                System.out.print(holdingArray.get(i));
            }
            System.out.println();

        }
    }

    private void mainMenu(){
        printMap();
        game.askUser();
    }

    private void askUser() {
        System.out.println("What direction would you like to move?");

        String userInput = keyboard.nextLine();
        userTextLowercase = userInput.toLowerCase();
        game.moveLocation(userInput);
        game.findPlace(currentPlace);
    }


    private void moveLocation(String userInputtedDirection){
        String holdingValue;
        final int TOP_MAP = 0;
        final int BOTTOM_MAP = 4;
        final int EAST_MAP = 7;
        final int WEST_MAP = 0;

        userInputtedDirection = userInputtedDirection.toLowerCase();


        if (!cardinalDirections.containsKey(userInputtedDirection)){
            System.out.println("I do not recognize that direction");
            askUser();

        }
        int movement = cardinalDirections.get(userInputtedDirection);
        if(movement == NORTH){

            if(yCoordinate <= TOP_MAP){
                System.out.println("You cannot move North");
            } else{
                holdingValue = map.get(yCoordinate -1).get(xCoordinate);
                map.get(yCoordinate).set(xCoordinate, currentPlace);
                map.get(yCoordinate - 1).set(xCoordinate, "@ ");
                currentPlace = holdingValue;
                yCoordinate--;
            }
        } else if(movement == EAST){

            if(xCoordinate >= EAST_MAP){
                System.out.println("You cannot move East");
            } else{
                //Set holdingValue to the icon at the new position
                holdingValue = map.get(yCoordinate).get(xCoordinate + 1);
                //Set old position as currentPlace
                map.get(yCoordinate).set(xCoordinate, currentPlace);
                //Set new position as "@ "
                map.get(yCoordinate).set(xCoordinate + 1, "@ ");
                //Set currentPlace as the new currentValue
                currentPlace = holdingValue;
                xCoordinate++;
            }

        } else if(movement == SOUTH){

            if(yCoordinate >= BOTTOM_MAP){
                System.out.println("You cannot move South");
            } else{
                holdingValue = map.get(yCoordinate + 1).get(xCoordinate);
                map.get(yCoordinate).set(xCoordinate, currentPlace);
                map.get(yCoordinate + 1).set(xCoordinate, "@ ");
                currentPlace = holdingValue;
                yCoordinate++;
            }

        } else if(movement == WEST){

            if(xCoordinate <= WEST_MAP){
                System.out.println("You cannot move West");
            } else{
                holdingValue = map.get(yCoordinate).get(xCoordinate - 1);
                map.get(yCoordinate).set(xCoordinate, currentPlace);
                map.get(yCoordinate).set(xCoordinate - 1, "@ ");
                currentPlace = holdingValue;
                xCoordinate--;
            }

        } else{
            System.out.println("I do not recognize that direction");
            askUser();
        }
        printMap();
        findPlace(currentPlace);
        askUser();
    }

    private void findPlace(String location){
        System.out.println(placeEvent.get(location));

    }
}
