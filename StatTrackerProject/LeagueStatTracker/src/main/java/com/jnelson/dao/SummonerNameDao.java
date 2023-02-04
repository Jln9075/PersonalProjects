package com.jnelson.dao;

import com.jnelson.classes.SummonerName;

public class SummonerNameDao extends DaoBase {

    public SummonerName getSummonerName(String userInputtedName){
        SummonerName summoner;
        summoner = restTemplate.getForObject(PULL_SUMMONER_BY_NAME + userInputtedName + "?" + TEMPORARY_API_KEY, SummonerName.class);

        return summoner;
    }

}
