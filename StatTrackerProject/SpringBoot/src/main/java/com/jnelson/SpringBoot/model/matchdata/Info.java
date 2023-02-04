package com.jnelson.SpringBoot.model.matchdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DecimalFormat;

public class Info {
    @JsonProperty("participants")
    ParticipantData[] participantData;
    double gameDuration;
    DecimalFormat dcf = new DecimalFormat("###.##");

    public Info() {
    }

    public Info(ParticipantData[] participantData, double gameDuration) {
        this.participantData = participantData;
        this.gameDuration = gameDuration;
    }

    public ParticipantData[] getParticipantData() {
        return participantData;
    }

    public void setParticipantData(ParticipantData[] participantData) {
        this.participantData = participantData;
    }

    public double getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(double gameDuration) {
        this.gameDuration = gameDuration;
    }

}
