package com.jnelson.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;

import java.util.List;

public class ReturnData {

    String summonerName;
    Integer totalCreepScore = null;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<Double> averageCreepScore = null;
    String championName = null;
    String individualPosition = null;
    String gameDuration;

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
