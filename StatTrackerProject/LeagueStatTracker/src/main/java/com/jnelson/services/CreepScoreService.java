package com.jnelson.services;

import com.jnelson.classes.MatchData;
import com.jnelson.classes.MatchHistory;
import com.jnelson.classes.SummonerName;
import com.jnelson.classes.matchdata.Info;
import com.jnelson.classes.matchdata.ParticipantData;
import com.jnelson.dao.MatchDataDao;
import com.jnelson.dao.MatchHistoryDao;
import org.springframework.lang.Nullable;

import java.text.DecimalFormat;

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

    public double getCspmForXMatches(SummonerName summonerName, int amountOfMatches){
        MatchData[] matchDataArray;
        ParticipantData[] participantData;
        double totalUndividedCreepScore = 0.00;
        double averageGameDuration = 0.00;
        MatchHistory[] matchHistoryArray = matchHistoryDao.getLastXMatches(summonerName, amountOfMatches);
        matchDataArray = matchDataDao.getLastXMatchData(matchHistoryArray);
        for(int i = 0; i < matchDataArray.length; i++){
            participantData = matchDataArray[i].getInfo().getParticipantData();
            averageGameDuration += matchDataArray[i].getInfo().getGameDuration();
            for(int j = 0; j < participantData.length; j++){
                String participantName = participantData[j].getSummonerName();
                if(participantName.equals(summonerName.getUserName())){
                     totalUndividedCreepScore += participantData[j].getTotalCreepScore();
                }
            }

        }

        return (totalUndividedCreepScore/amountOfMatches)/(averageGameDuration/amountOfMatches/60);
    }



}
