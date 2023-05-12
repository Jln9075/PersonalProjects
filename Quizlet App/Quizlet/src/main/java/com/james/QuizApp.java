package com.james;

import java.io.File;
import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        MenuServices menuServices = new MenuServices();
        File directory = new File("C:\\Users\\Dev Machine\\Workspace\\PersonalProjects\\Quizlet App\\Quizlet\\src\\main\\Quizzes");
        int userResponse;

        String[] children = directory.list();
        for(String element : children) {
            System.out.println(element);
        }
        do {
            menuServices.startMenu();
            String userInput = keyboard.nextLine().toLowerCase();
            userResponse = menuServices.mainMenu(userInput);
        }while(userResponse != 1);


    }
}