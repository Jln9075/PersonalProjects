package com.jnelson.SpringBoot.dao;

import com.jnelson.SpringBoot.model.MatchHistory;
import com.jnelson.SpringBoot.model.SummonerName;

public class MatchHistoryDao extends DaoBase{

    public MatchHistory[] getMostRecentMatch(SummonerName summonerName){
        MatchHistory[] matchHistory;

        matchHistory = restTemplate.getForObject(PULL_MATCH_HISTORY_BY_PUUID + summonerName.getPuuid() + "/ids?start=0&count=1&" + API_KEY, MatchHistory[].class);
        return matchHistory;
    }

    public MatchHistory[] getLastXMatches(SummonerName summonerName, int amountOfMatches){
        MatchHistory[] matchHistory;

        matchHistory = restTemplate.getForObject(PULL_MATCH_HISTORY_BY_PUUID + summonerName.getPuuid() + "/ids?start=0&count=" + amountOfMatches + "&" + API_KEY, MatchHistory[].class);
        return matchHistory;
    }

}
