package model;

public class Team {
    private int teamId;
    private String name;
    private String country;
    private double teamRating;

    public Team(int teamId, String name, String country, double teamRating) {
        this.teamId = teamId;
        this.name = name;
        this.country = country;
        this.teamRating = teamRating;
    }

    public int getTeamId() {
        return teamId;
    }
    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
    public double getTeamRating() {
        return teamRating;
    }
}
