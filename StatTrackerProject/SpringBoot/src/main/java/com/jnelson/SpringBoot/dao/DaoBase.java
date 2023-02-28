package com.jnelson.SpringBoot.dao;

import org.springframework.web.client.RestTemplate;

public abstract class DaoBase {
    protected final String PULL_MATCH_HISTORY_BY_PUUID = "https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/";
    protected final String PULL_SUMMONER_BY_NAME = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
    protected final String API_KEY = "api_key=RGAPI-cdbb6976-600b-4584-906e-f7d2d271285c";
    protected final RestTemplate restTemplate = new RestTemplate();
}
