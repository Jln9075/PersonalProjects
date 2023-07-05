package com.jnelson.SpringBoot.model.matchdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

public class Info {
    @JsonProperty("participants")
    private ParticipantData[] participantData;
    private double gameDuration;

    public Info() {
    }


    public ParticipantData[] getParticipantData() {
        return participantData;
    }

    public double getGameDuration() {
        return gameDuration;
    }

    public String getFormattedGameDuration() {

        int minutes = (int) (gameDuration/60);
        int seconds = (int) (gameDuration) - minutes*60;
        String formattedDuration = minutes + ":" + seconds;
        if(formattedDuration.length() == 4){
            formattedDuration = formattedDuration.substring(0, 3) + "0" + formattedDuration.substring(3);
        }
        return formattedDuration;
    }


}
