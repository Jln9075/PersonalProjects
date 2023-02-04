package com.jnelson;

import com.jnelson.dao.FoodItemDao;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        FoodItemDao foodItemDao = new FoodItemDao();

        Scanner keyboard = new Scanner(System.in);

        System.out.println("What Kind of Food are you looking for?");
        String userInput = keyboard.next();

        System.out.println(foodItemDao.getFoodItem(userInput));

    }
}
