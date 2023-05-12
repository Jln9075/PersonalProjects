package com.james;

public class MenuServices {


    public void startMenu() {

        System.out.println("What would you like to do?");
        System.out.println("* * * * * * * * * * * * * *");
        System.out.println("1. Take a quiz");
        System.out.println("2. Make a new quiz");
        System.out.println("3. End program");
    }
    public int startMenuResponses(String userInput){


            if (userInput.equals("1")) {
                System.out.println("Great! Let's start!");
                return 1;
            } else if(userInput.equals("2")){
                System.out.println("Sure, we can do that");
            } else if (userInput.equals("3")) {
                System.out.println("Okay, goodbye");
                System.exit(0);
            } else {
                System.out.println("I'm sorry, I don't recognize that command");
                return 0;
            }
            return 0;
    }

    public void quizMenu(String[] quizList){

        System.out.println("What quiz would you like to take?");
        for(int i = 1; i <= quizList.length; i++) {
            System.out.println(i + ". " + quizList[i - 1]);
        }

    }

    public int quizMenuResponses(int userInput, String[] quizList){

        if(userInput > 0 && userInput <= quizList.length){
            System.out.println("Hell yeah");
        } else{
            System.out.println("I'm sorry, I don't think that was one of the options");
        }
        return 0;
    }
}
