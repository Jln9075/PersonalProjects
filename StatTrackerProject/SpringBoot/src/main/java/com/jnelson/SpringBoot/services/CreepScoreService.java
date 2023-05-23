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
        int totalCreepScore = 0;


        MatchHistory[] matchHistoryArray = matchHistoryDao.getLastXMatches(summonerName, amountOfMatches);
        matchData = matchDataDao.getLastXMatchData(matchHistoryArray);

//TODO rewrite program to allow multiple matches to get searched instead of 1
        for(int i = 0; i < 10; i++){
            participantData = matchData.get(matchHistoryArray[0]).getInfo().getParticipantData();
            if(participantData[i].getSummonerName().equals(summonerName.getUserName())){
                totalCreepScore = participantData[i].getTotalCreepScore();
                returnData[0] = new ReturnData(participantData[i].getSummonerName(),
                        totalCreepScore,
                        participantData[i].getChampionName(),
                        participantData[i].getIndividualPosition(),
                        matchData.get(matchHistoryArray[0]).getInfo().getFormattedGameDuration());
                break;
            }
        }

        return returnData;
    }

//
//    public double getCreepScorePerMinuteForUser(SummonerName summonerName){
//        ParticipantData[] participantData;
//        double creepScorePerMinute = 0.00;
//        MatchHistory[] matchHistoryArray = matchHistoryDao.getMostRecentMatch(summonerName);
//        matchData = matchDataDao.getRecentMatchData(matchHistoryArray);
//        participantData = matchData.getInfo().getParticipantData();
//
//        for(int i = 0; i < participantData.length; i++){
//            if(participantData[i].getSummonerName().equals(summonerName.getUserName())){
//                creepScorePerMinute = participantData[i].getTotalCreepScore()/(matchData.getInfo().getGameDuration());
//            }
//        }
//        return creepScorePerMinute;
//    }
//
//    public List<Double> getAverageCreepScoreOverXMatches(SummonerName summonerName, int amountOfMatches){
//        MatchData[] matchDataArray;
//        ParticipantData[] participantData;
//        List<Double> creepScoreList = new ArrayList<>();
//        MatchHistory[] matchHistoryArray = matchHistoryDao.getLastXMatches(summonerName, amountOfMatches);
//        matchDataArray = matchDataDao.getLastXMatchData(matchHistoryArray);
//
////TODO  Investigate rewriting this method using a hashmap instead of the first for loop
//        for(int i = 0; i < matchDataArray.length; i++){
//            participantData = matchDataArray[i].getInfo().getParticipantData();
//            for(int j = 0; j < participantData.length; j++){
//                String participantName = participantData[j].getSummonerName();
//                if(participantName.equals(summonerName.getUserName())){
//                     creepScoreList.add((double) (participantData[j].getTotalCreepScore())/(matchDataArray[i].getInfo().getGameDuration()));
//                }
//            }
//
//        }
//
//        return creepScoreList;
//    }



}
