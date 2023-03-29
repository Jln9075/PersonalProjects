package com.jnelson.SpringBoot.dao;

import com.jnelson.SpringBoot.model.MatchData;
import com.jnelson.SpringBoot.model.MatchHistory;

public class MatchDataDao extends DaoBase {
    protected final String PULL_MATCH_DATA = "https://americas.api.riotgames.com/lol/match/v5/matches/";

    public MatchData getRecentMatchData(MatchHistory[] matchHistory){
        MatchData matchData;

        matchData = restTemplate.getForObject(PULL_MATCH_DATA + matchHistory[0].getMatchId() + "?" + API_KEY, MatchData.class);

        return matchData;
    }

    public MatchData[] getLastXMatchData(MatchHistory[] matchHistory){
        MatchData[] matchData = new MatchData[matchHistory.length];

        for(int i = 0; i < matchData.length; i++){
            matchData[i] = restTemplate.getForObject(PULL_MATCH_DATA + matchHistory[i].getMatchId() + "?" + API_KEY, MatchData.class);
        }
        return matchData;
    }




}
