package com.jnelson.SpringBoot.dao;

import com.jnelson.SpringBoot.model.SummonerName;


public class SummonerNameDao extends DaoBase {

    public SummonerName getSummonerName(String userInputtedName){
        SummonerName summoner;
        summoner = restTemplate.getForObject(PULL_SUMMONER_BY_NAME + userInputtedName + "?" + API_KEY, SummonerName.class);

        return summoner;
    }

}
