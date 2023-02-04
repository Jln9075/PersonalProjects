package com.jnelson.SpringBoot.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class SummonerName {


    String puuid;
    @JsonProperty("name")
    String userName;


    public SummonerName(){

    }

    public SummonerName(String puuid, String userName) {
        this.puuid = puuid;
        this.userName = userName;
    }

    public String getPuuid() {
        return puuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    @Override
    public String toString() {
        return "SummonerName{" +
                "username='" + userName + '\'' +
                ", puuid='" + puuid + '\'' +
                '}';
    }
}