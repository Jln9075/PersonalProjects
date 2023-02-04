package com.jnelson.SpringBoot.model.matchdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParticipantData {

    int neutralMinionsKilled;
    int totalMinionsKilled;
    @JsonProperty("gameLength")
    double gameLengthInSeconds;
    String summonerName;
    double creepScorePerMinute;
    int totalCreepScore;

    public ParticipantData() {

    }

    public ParticipantData(int totalMinionsKilled, String summonerName, int neutralMinionsKilled, double gameLengthInSeconds) {
        this.totalMinionsKilled = totalMinionsKilled;
        this.summonerName = summonerName;
        this.neutralMinionsKilled = neutralMinionsKilled;
        this.gameLengthInSeconds = gameLengthInSeconds;
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
