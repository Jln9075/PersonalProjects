package com.jnelson.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;

import java.util.List;

public class ReturnData {

    private String summonerName;
    private Integer totalCreepScore = null;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Double> averageCreepScore = null;
    private String championName = null;
    private String individualPosition = null;
    private String gameDuration;

    public ReturnData(String summonerName, Integer totalCreepScore, String championName, String individualPosition, String gameDuration) {
        this.summonerName = summonerName;
        this.totalCreepScore = totalCreepScore;
        this.championName = championName;
        this.individualPosition = individualPosition;
        this.gameDuration = gameDuration;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public Integer getTotalCreepScore() {
        return totalCreepScore;
    }

    public List<Double> getAverageCreepScore() {
        return averageCreepScore;
    }

    public String getChampionName() {
        return championName;
    }

    public String getIndividualPosition() {
        return individualPosition;
    }
    public String getGameDuration() {
        return gameDuration;
    }
}
