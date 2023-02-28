package com.techelevator;

public class HotelReservation {
    String name;
    int numberOfNights;
    int nightlyRate;
    int estimatedTotal;

    public HotelReservation(String name, int numberOfNights, int nightlyRate) {
        this.name = name;
        this.numberOfNights = numberOfNights;
        this.nightlyRate = nightlyRate;
    }

    public int getActualTotal(boolean requiresCleaning, boolean usedMiniBar){
        int actualTotal = getEstimatedTotal();

        if(requiresCleaning){
            actualTotal += 25;
        }
        if(usedMiniBar){
            actualTotal += 15;
            if(requiresCleaning){
                actualTotal +=25;
            }
        }
        return actualTotal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public int getNightlyRate() {
        return nightlyRate;
    }

    public void setNightlyRate(int nightlyRate) {
        this.nightlyRate = nightlyRate;
    }

    public int getEstimatedTotal() {
        return numberOfNights * nightlyRate;
    }

    @Override
    public String toString() {
        return name + ":" + getEstimatedTotal();
    }
}
