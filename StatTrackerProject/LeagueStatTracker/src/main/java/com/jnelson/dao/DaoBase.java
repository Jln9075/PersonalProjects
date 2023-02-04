package com.jnelson.dao;

import org.springframework.web.client.RestTemplate;

public abstract class DaoBase {
    protected final String PULL_MATCH_HISTORY_BY_PUUID = "https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/";
    protected final String PULL_SUMMONER_BY_NAME = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
    protected final String TEMPORARY_API_KEY = "api_key=" + "RGAPI-b2bbdec9-c703-427d-a28b-0ec89f74dea6";// TODO replace every day
    protected final RestTemplate restTemplate = new RestTemplate();
}
