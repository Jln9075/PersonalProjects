package com.james;

import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Hello!");
        System.out.println("Would you like to play a game? (Y/N)");

        String userInput = keyboard.nextLine();


        if(userInput.equalsIgnoreCase("y")){

        } else if(userInput.equalsIgnoreCase("n")) {

        } else {
            System.out.println("I'm sorry, I don't recognize that command");

        }

        System.out.println(userInput);
    }
}