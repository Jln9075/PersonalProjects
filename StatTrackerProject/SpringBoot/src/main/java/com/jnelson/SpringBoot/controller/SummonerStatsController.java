package com.jnelson.SpringBoot.controller;

import com.jnelson.SpringBoot.model.ReturnData;
import com.jnelson.SpringBoot.model.SummonerName;
import com.jnelson.SpringBoot.services.CreepScoreService;
import com.jnelson.SpringBoot.services.SummonerNameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "")
public class SummonerStatsController {

    private CreepScoreService creepScoreService;
    private SummonerNameService summonerNameService;

    public SummonerStatsController(CreepScoreService creepScoreService, SummonerNameService summonerNameService){
        this.creepScoreService = creepScoreService;
        this.summonerNameService = summonerNameService;
    }

    @RequestMapping( path = "creepScore/{userInputtedName}", method = RequestMethod.GET )
    public ReturnData getCreepScore(@PathVariable String userInputtedName){
        SummonerName summonerName;
        summonerName = summonerNameService.stringToSummonerName(userInputtedName);
        ReturnData returnData = new ReturnData(summonerName.getUserName(), creepScoreService.getCreepScoreForUser(summonerName), null);
        return returnData;
    }

   /* @RequestMapping( path = "/averageCreepScore/{userInputtedName}", method = RequestMethod.GET )
    public ReturnData getAverageCreepScore(@PathVariable String userInputtedName){
        SummonerName summonerName;
        summonerName = summonerNameService.stringToSummonerName(userInputtedName);
        ReturnData returnData = new ReturnData(summonerName.getUserName(), null, creepScoreService.getAverageCreepScoreOverXMatches(summonerName, 1).get(1));
        return returnData;
    }*/

    @RequestMapping( path = "/averageCreepScore/{userInputtedName}/{matchNumber}", method = RequestMethod.GET)
    public ReturnData getAverageCreepScore(@PathVariable String userInputtedName, @PathVariable int matchNumber){
    SummonerName summonerName;
    summonerName = summonerNameService.stringToSummonerName(userInputtedName);
    List<Double> creepScoreList = creepScoreService.getAverageCreepScoreOverXMatches(summonerName, matchNumber);
    return new ReturnData(summonerName.getUserName(), null, creepScoreList);

    }
}