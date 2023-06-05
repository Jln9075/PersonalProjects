package com.jnelson.SpringBoot.services;

import com.jnelson.SpringBoot.dao.MatchHistoryDao;
import com.jnelson.SpringBoot.model.MatchData;
import com.jnelson.SpringBoot.model.MatchHistory;
import com.jnelson.SpringBoot.model.ReturnData;
import com.jnelson.SpringBoot.model.SummonerName;
import com.jnelson.SpringBoot.model.matchdata.ParticipantData;
import com.jnelson.SpringBoot.dao.MatchDataDao;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class CreepScoreService {
    MatchHistoryDao matchHistoryDao = new MatchHistoryDao();
    MatchDataDao matchDataDao = new MatchDataDao();
    HashMap<MatchHistory, MatchData> matchData;


    public CreepScoreService() {
    }

    public CreepScoreService(MatchHistoryDao matchHistoryDao, MatchDataDao matchDataDao, HashMap<MatchHistory, MatchData> matchData) {
        this.matchHistoryDao = matchHistoryDao;
        this.matchDataDao = matchDataDao;
        this.matchData = matchData;
    }

    public ReturnData[] getCreepScoreForUser(SummonerName summonerName, int amountOfMatches){
        ParticipantData[] participantData;
        ReturnData[] returnData = new ReturnData[amountOfMatches];

        MatchHistory[] matchHistoryArray = matchHistoryDao.getLastXMatches(summonerName, amountOfMatches);
        matchData = matchDataDao.getLastXMatchData(matchHistoryArray);

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
