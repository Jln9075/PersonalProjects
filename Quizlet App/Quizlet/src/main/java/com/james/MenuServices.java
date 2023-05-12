package com.james;

public class MenuServices {


    public void startMenu() {

        System.out.println("Would you like to take a quiz? (Y/N)");
    }
    public int mainMenu(String userInput){


            if (userInput.equals("y")) {
                System.out.println("Great! Let's start!");
                return 1;
            } else if (userInput.equals("n")) {
                System.out.println("Okay, goodbye");
                System.exit(0);
                return 0;
            } else {
                System.out.println("I'm sorry, I don't recognize that command");
                return 2;
            }

    }
}
