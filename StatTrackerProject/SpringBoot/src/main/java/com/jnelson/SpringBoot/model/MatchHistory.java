package com.jnelson.SpringBoot.model;

public class MatchHistory {
    String matchId;

    public MatchHistory(String matchId) {
        this.matchId = matchId;
    }

    public MatchHistory() {
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    @Override
    public String toString() {
        return "MatchHistory{" +
                "matchId='" + matchId + '\'' +
                '}';
    }
}
