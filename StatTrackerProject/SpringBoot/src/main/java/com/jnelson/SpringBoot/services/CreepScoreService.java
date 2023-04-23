package com.jnelson.SpringBoot.services;

import com.jnelson.SpringBoot.dao.MatchHistoryDao;
import com.jnelson.SpringBoot.model.MatchData;
import com.jnelson.SpringBoot.model.MatchHistory;
import com.jnelson.SpringBoot.model.SummonerName;
import com.jnelson.SpringBoot.model.matchdata.ParticipantData;
import com.jnelson.SpringBoot.dao.MatchDataDao;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreepScoreService {
    MatchHistoryDao matchHistoryDao = new MatchHistoryDao();
    MatchDataDao matchDataDao = new MatchDataDao();
    MatchData matchData;
    DecimalFormat dcf = new DecimalFormat("###.##");


    public CreepScoreService() {
    }

    public CreepScoreService(MatchHistoryDao matchHistoryDao, MatchDataDao matchDataDao, MatchData matchData) {
        this.matchHistoryDao = matchHistoryDao;
        this.matchDataDao = matchDataDao;
        this.matchData = matchData;
    }

    public int getCreepScoreForUser(SummonerName summonerName){
        ParticipantData[] participantData;
        int totalCreepScore = 0;
        MatchHistory[] matchHistoryArray = matchHistoryDao.getMostRecentMatch(summonerName);
        matchData = matchDataDao.getRecentMatchData(matchHistoryArray);
        participantData = matchData.getInfo().getParticipantData();

        for(int i = 0; i < participantData.length; i++){
            if(participantData[i].getSummonerName().equals(summonerName.getUserName())){
                totalCreepScore = participantData[i].getTotalCreepScore();
            }
        }

        return totalCreepScore;
    }

    public double getCreepScorePerMinuteForUser(SummonerName summonerName){
        ParticipantData[] participantData;
        double creepScorePerMinute = 0.00;
        MatchHistory[] matchHistoryArray = matchHistoryDao.getMostRecentMatch(summonerName);
        matchData = matchDataDao.getRecentMatchData(matchHistoryArray);
        participantData = matchData.getInfo().getParticipantData();

        for(int i = 0; i < participantData.length; i++){
            if(participantData[i].getSummonerName().equals(summonerName.getUserName())){
                creepScorePerMinute = participantData[i].getTotalCreepScore()/(matchData.getInfo().getGameDuration()/60);
            }
        }
        return creepScorePerMinute;
    }

    public List<Double> getAverageCreepScoreOverXMatches(SummonerName summonerName, int amountOfMatches){
        MatchData[] matchDataArray;
        ParticipantData[] participantData;
        List<Double> creepScoreList = new ArrayList<>();
        MatchHistory[] matchHistoryArray = matchHistoryDao.getLastXMatches(summonerName, amountOfMatches);
        matchDataArray = matchDataDao.getLastXMatchData(matchHistoryArray);
        for(int i = 0; i < matchDataArray.length; i++){
            participantData = matchDataArray[i].getInfo().getParticipantData();
            for(int j = 0; j < participantData.length; j++){
                String participantName = participantData[j].getSummonerName();
                if(participantName.equals(summonerName.getUserName())){
                     creepScoreList.add((double) (participantData[j].getTotalCreepScore())/(matchDataArray[i].getInfo().getGameDuration()/60));
                }
            }

        }

        return creepScoreList;
    }



}
