package com.jnelson.SpringBoot.dao;

import org.springframework.web.client.RestTemplate;

public abstract class DaoBase {
    protected final String PULL_MATCH_HISTORY_BY_PUUID = "https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/";
    protected final String PULL_SUMMONER_BY_NAME = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
    protected final String TEMPORARY_API_KEY = "api_key=" + "RGAPI-9cfb6d7a-89f9-465b-bd8d-4a8e97e2c766";// TODO replace every day
    protected final RestTemplate restTemplate = new RestTemplate();
}
