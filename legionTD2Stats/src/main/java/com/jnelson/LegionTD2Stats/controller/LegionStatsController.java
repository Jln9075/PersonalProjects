package com.jnelson.LegionTD2Stats.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "")
public class LegionStatsController {

    public LegionStatsController(){
        System.out.println("hello");

    }

    @RequestMapping( path = "userId/{userInputtedName}", method = RequestMethod.GET)
    public String getUserId(@PathVariable String userInputtedName){

        final String PULL_USER_ID = "https://apiv2.legiontd2.com/players/byName/" + userInputtedName;
        return "hello";
    }
}
