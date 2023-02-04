package com.jnelson.classes.matchdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ParticipantData {

    int neutralMinionsKilled;
    int totalMinionsKilled;
    double gameLengthInSeconds;
    String summonerName;
    double creepScorePerMinute;
    int totalCreepScore;

    public ParticipantData() {

    }

    public ParticipantData(int totalMinionsKilled, String summonerName, int neutralMinionsKilled) {
        this.totalMinionsKilled = totalMinionsKilled;
        this.summonerName = summonerName;
        this.neutralMinionsKilled = neutralMinionsKilled;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public int getTotalMinionsKilled() {
        return totalMinionsKilled;
    }

    public double getGameLengthInSeconds() {
        return gameLengthInSeconds;
    }


    public int getTotalCreepScore(){
        this.totalCreepScore = neutralMinionsKilled + totalMinionsKilled;
        return totalCreepScore;
    }

    public int getNeutralMinionsKilled() {
        return neutralMinionsKilled;
    }

    @Override
    public String toString() {
        return "ParticipantData{" +
                "creepScorePerMinute=" + creepScorePerMinute +
                '}';
    }
}
