package com.jnelson.SpringBoot.services;

import com.jnelson.SpringBoot.model.SummonerName;
import org.springframework.stereotype.Component;

@Component
public class SummonerNameService extends ServiceBase {


    public SummonerNameService() {
    }


    public SummonerName stringToSummonerName(String userInputtedName){
        SummonerName summoner;
        summoner = restTemplate.getForObject(PULL_SUMMONER_BY_NAME + userInputtedName + "?" + API_KEY, SummonerName.class);

        return summoner;
    }
}
