package com.jnelson.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;

import java.util.List;

public class ReturnData {

    String summonerName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer totalCreepScore = null;
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    //Double averageCreepScore = null;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<Double> averageCreepScore = null;

    public ReturnData(String summonerName, @Nullable Integer totalCreepScore, @Nullable List<Double> averageCreepScore) {
        this.summonerName = summonerName;
        this.totalCreepScore = totalCreepScore;
        this.averageCreepScore = averageCreepScore;
    }

}
