package com.james;

import java.io.File;
import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        MenuServices menuServices = new MenuServices();
        QuizService quizService = new QuizService();
        final File quizDirectory = new File("C:\\Users\\Dev Machine\\Workspace\\PersonalProjects\\Quizlet App\\Quizlet\\src\\main\\Quizzes");
        int userResponse = 0;
        String[] quizList = quizDirectory.list();


        System.out.println("");
        System.out.println("Welcome to the Quiz App!");

        do {

            String userInput;
            if (userResponse == 0) {
                menuServices.startMenu();
                userInput = keyboard.nextLine();
                userResponse = menuServices.startMenuResponses(userInput);

            } else if(userResponse == 1){
                menuServices.quizMenu(quizList);
                userInput = keyboard.nextLine();

                // TODO use a try-catch method to avoid runtime errors
                menuServices.quizMenuResponses(Integer.parseInt(userInput), quizList);
                quizService.startQuiz(quizDirectory);

            } else if(userResponse == 2){

            }

        }while(userResponse >=0);





    }
}