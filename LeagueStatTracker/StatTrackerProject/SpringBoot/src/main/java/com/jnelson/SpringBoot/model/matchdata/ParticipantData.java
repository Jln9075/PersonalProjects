package com.jnelson.SpringBoot.model.matchdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParticipantData {

    private int neutralMinionsKilled;
    private int totalMinionsKilled;
    @JsonProperty("gameLength")
    private double gameLengthInSeconds;
    private String summonerName;
    private double creepScorePerMinute;
    private int totalCreepScore;
    private String championName;
    private String individualPosition;

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
