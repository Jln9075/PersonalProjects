package com.jnelson.SpringBoot.services;

import com.jnelson.SpringBoot.model.MatchData;
import com.jnelson.SpringBoot.model.MatchHistory;
import com.jnelson.SpringBoot.model.ReturnData;
import com.jnelson.SpringBoot.model.SummonerName;
import com.jnelson.SpringBoot.model.matchdata.ParticipantData;
import org.springframework.stereotype.Component;


import java.util.HashMap;

@Component
public class MatchInformationService extends ServiceBase {

    HashMap<MatchHistory, MatchData> matchData;
    protected final String PULL_MATCH_DATA = "https://americas.api.riotgames.com/lol/match/v5/matches/";


    public MatchInformationService() {
    }

    public MatchInformationService(HashMap<MatchHistory, MatchData> matchData) {
        this.matchData = matchData;
    }

    public MatchHistory[] getLastXMatches(SummonerName summonerName, int amountOfMatches){
        MatchHistory[] matchHistory;
        matchHistory = restTemplate.getForObject(PULL_MATCH_HISTORY_BY_PUUID + summonerName.getPuuid() + "/ids?start=0&count=" + amountOfMatches + "&" + API_KEY, MatchHistory[].class);

        return matchHistory;
    }

    public HashMap<MatchHistory, MatchData> getLastXMatchData(MatchHistory[] matchHistory){
        HashMap<MatchHistory, MatchData> matchData = new HashMap<>(matchHistory.length);

        for (MatchHistory history : matchHistory) {
            matchData.put(history, restTemplate.getForObject(PULL_MATCH_DATA + history.getMatchId() + "?" + API_KEY, MatchData.class));
        }
        return matchData;
    }

    public ReturnData[] getCreepScoreForUser(SummonerName summonerName, int amountOfMatches){

        ParticipantData[] participantData;
        ReturnData[] returnData = new ReturnData[amountOfMatches];

        MatchHistory[] matchHistoryArray = getLastXMatches(summonerName, amountOfMatches);
        matchData = getLastXMatchData(matchHistoryArray);

        for(int matchCount = 0; matchCount < amountOfMatches; matchCount++){

            for(int participantcount = 0; participantcount < 10; participantcount++){

                participantData = matchData.get(matchHistoryArray[matchCount]).getInfo().getParticipantData();

                    if(participantData[participantcount].getSummonerName().equals(summonerName.getUserName())) {
                        returnData[matchCount] = new ReturnData(participantData[participantcount].getSummonerName(), participantData[participantcount].getTotalCreepScore(),
                            participantData[participantcount].getChampionName(),
                            participantData[participantcount].getIndividualPosition(),
                            matchData.get(matchHistoryArray[matchCount]).getInfo().getFormattedGameDuration());
                        break;
                }
            }
        }

        return returnData;
    }



}
