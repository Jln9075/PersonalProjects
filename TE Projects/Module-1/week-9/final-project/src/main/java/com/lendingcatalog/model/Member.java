package com.lendingcatalog.model;

public class Member {
    String firstName = "";
    String lastName = "";

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Member(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString(){
        return firstName + " " + lastName;
    }

}
