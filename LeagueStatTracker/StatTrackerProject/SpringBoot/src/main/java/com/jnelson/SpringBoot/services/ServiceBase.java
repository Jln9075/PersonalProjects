package com.jnelson.SpringBoot.services;

import org.springframework.web.client.RestTemplate;

public abstract class ServiceBase {
    protected final String PULL_MATCH_HISTORY_BY_PUUID = "https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/";
    protected final String PULL_SUMMONER_BY_NAME = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
    protected final String API_KEY = "api_key=" + "RGAPI-71313d54-4c40-47bf-b363-a348356fca0f";
    protected final RestTemplate restTemplate = new RestTemplate();
}
