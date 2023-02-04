package com.jnelson.dao;

import com.jnelson.classes.MatchHistory;
import com.jnelson.classes.SummonerName;

public class MatchHistoryDao extends DaoBase{

    public MatchHistory[] getMostRecentMatch(SummonerName summonerName){
        MatchHistory[] matchHistory;

        matchHistory = restTemplate.getForObject(PULL_MATCH_HISTORY_BY_PUUID + summonerName.getPuuid() + "/ids?start=0&count=1&" + TEMPORARY_API_KEY, MatchHistory[].class);
        return matchHistory;
    }

    public MatchHistory[] getLastXMatches(SummonerName summonerName, int amountOfMatches){
        MatchHistory[] matchHistory;

        matchHistory = restTemplate.getForObject(PULL_MATCH_HISTORY_BY_PUUID + summonerName.getPuuid() + "/ids?start=0&count=" + amountOfMatches + "&" + TEMPORARY_API_KEY, MatchHistory[].class);
        return matchHistory;
    }

}
