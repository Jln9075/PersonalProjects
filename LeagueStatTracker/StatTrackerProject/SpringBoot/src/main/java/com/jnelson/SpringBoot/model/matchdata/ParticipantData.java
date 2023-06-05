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
    String championName;
    String individualPosition;

    public ParticipantData() {

    }

    public ParticipantData(int totalMinionsKilled, String summonerName, int neutralMinionsKilled, double gameLengthInSeconds, String championName, String individualPosition) {
        this.totalMinionsKilled = totalMinionsKilled;
        this.summonerName = summonerName;
        this.neutralMinionsKilled = neutralMinionsKilled;
        this.gameLengthInSeconds = gameLengthInSeconds;
        this.championName = championName;
        this.individualPosition = individualPosition;
    }

    public String getIndividualPosition() {
        return individualPosition;
    }

    public String getChampionName() {
        return championName;
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
