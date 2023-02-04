package com.jnelson.dao;

import com.jnelson.model.FoodItem;
import org.springframework.web.client.RestTemplate;

public class FoodItemDao {

    final String API_BASE_URL = "https://api.nal.usda.gov/fdc/v1/foods/";
    final String API_KEY = "&api_key=PS0EZ9jllhPnOFPRrhsApPhLvdJPjycRbtyZftvc";
    final String SEARCH_QUERY = "search?query=";
    private final RestTemplate restTemplate = new RestTemplate();


    public FoodItem getFoodItem(String userInputtedItem){
      FoodItem foodItem;
      String formattedSearchTerm = userInputtedItem.replaceAll(" ", "%20");
      foodItem = restTemplate.getForObject(API_BASE_URL + SEARCH_QUERY + formattedSearchTerm + "&numberOfResultsPerPage=1&pageSize=1" + API_KEY, FoodItem.class);
      return foodItem;
    }

}
