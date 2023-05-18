package com.jnelson.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;

import java.util.List;

public class ReturnData {

    String summonerName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer totalCreepScore = null;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<Double> averageCreepScore = null;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String championName = null;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String individualPosition = null;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String gameDuration;

    public ReturnData(String summonerName, @Nullable Integer totalCreepScore, @Nullable List<Double> averageCreepScore, @Nullable String championName, @Nullable String individualPosition, @Nullable String gameDuration) {
        this.summonerName = summonerName;
        this.totalCreepScore = totalCreepScore;
        this.averageCreepScore = averageCreepScore;
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
