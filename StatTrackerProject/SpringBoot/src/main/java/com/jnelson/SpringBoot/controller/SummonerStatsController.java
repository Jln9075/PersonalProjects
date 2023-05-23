package com.jnelson.SpringBoot.controller;

import com.jnelson.SpringBoot.model.ReturnData;
import com.jnelson.SpringBoot.model.SummonerName;
import com.jnelson.SpringBoot.services.CreepScoreService;
import com.jnelson.SpringBoot.services.SummonerNameService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "")
public class SummonerStatsController {

    private CreepScoreService creepScoreService;
    private SummonerNameService summonerNameService;

    public SummonerStatsController(CreepScoreService creepScoreService, SummonerNameService summonerNameService){
        this.creepScoreService = creepScoreService;
        this.summonerNameService = summonerNameService;
    }

    @RequestMapping( path = "creepScore/{userInputtedName}", method = RequestMethod.GET )
    public ReturnData[] getCreepScore(@PathVariable String userInputtedName){
        SummonerName summonerName;
        summonerName = summonerNameService.stringToSummonerName(userInputtedName);
        ReturnData[] returnData = creepScoreService.getCreepScoreForUser(summonerName, 1);
        System.out.println(returnData[0]);
        return returnData;
    }
////TODO investigate this method. Rewrite to return multiple return List of ReturnData including match metadata
//
//    @RequestMapping( path = "averageCreepScore/{userInputtedName}/{matchNumber}", method = RequestMethod.GET)
//    public ArrayList<ReturnData> getAverageCreepScore(@PathVariable String userInputtedName, @PathVariable int matchNumber){
//    SummonerName summonerName;
//    summonerName = summonerNameService.stringToSummonerName(userInputtedName);
//    List<ReturnData> creepScoreList = creepScoreService.getAverageCreepScoreOverXMatches(summonerName, matchNumber);
//    return new ReturnData(summonerName.getUserName(), null, creepScoreList);
//
//    }
}