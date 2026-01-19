package com.qrvoting.model;

public class Voter {
    private int id;
    private String name;
    private String email;
    private String password;
    private boolean hasVoted;

    public Voter(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.hasVoted = false;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean hasVoted() {
        return hasVoted;
    }
    public boolean isHasVoted() {
        return hasVoted;
    }

}
