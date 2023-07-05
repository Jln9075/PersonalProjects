package com.jnelson.SpringBoot.controller;

import com.jnelson.SpringBoot.model.ReturnData;
import com.jnelson.SpringBoot.model.SummonerName;
import com.jnelson.SpringBoot.services.MatchInformationService;
import com.jnelson.SpringBoot.services.SummonerNameService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "")
public class SummonerStatsController {

    private MatchInformationService matchInformationService;
    private SummonerNameService summonerNameService;

    public SummonerStatsController(MatchInformationService matchInformationService, SummonerNameService summonerNameService){
        this.matchInformationService = matchInformationService;
        this.summonerNameService = summonerNameService;
    }

    @RequestMapping( path = "creepScore/{userInputtedName}/{amountOfMatches}", method = RequestMethod.GET )
    public ReturnData[] getCreepScore(@PathVariable String userInputtedName, @PathVariable int amountOfMatches){
        SummonerName summonerName;
        summonerName = summonerNameService.stringToSummonerName(userInputtedName);
        ReturnData[] returnData = matchInformationService.getCreepScoreForUser(summonerName, amountOfMatches);
        return returnData;
    }

}