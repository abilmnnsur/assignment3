package model;

public class Player {
    private int playerId;
    private int teamId;
    private String nickname;
    private String realName;
    private String country;
    private double rating;
    private int kills;
    private int deaths;
    private int matchesPlayed;

    public Player(int playerId, int teamId, String nickname, String realName,
                  String country, double rating, int kills, int deaths, int matchesPlayed) {
        this.playerId = playerId;
        this.teamId = teamId;
        this.nickname = nickname;
        this.realName = realName;
        this.country = country;
        this.rating = rating;
        this.kills = kills;
        this.deaths = deaths;
        this.matchesPlayed = matchesPlayed;
    }

    // ===== GETTERS =====
    public int getPlayerId() { return playerId; }
    public int getTeamId() { return teamId; }
    public String getNickname() { return nickname; }
    public String getRealName() { return realName; }
    public String getCountry() { return country; }

    // чтобы не ломать старый код в сервисах/репозиториях:
    public double getRating() { return rating; }
    public double getPlayerRating() { return rating; }   // alias

    public int getKills() { return kills; }
    public int getDeaths() { return deaths; }
    public int getMatchesPlayed() { return matchesPlayed; }

    // ===== SETTERS (нужны для INSERT с generated keys) =====
    public void setPlayerId(int playerId) { this.playerId = playerId; }
    public void setTeamId(int teamId) { this.teamId = teamId; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setRealName(String realName) { this.realName = realName; }
    public void setCountry(String country) { this.country = country; }
    public void setRating(double rating) { this.rating = rating; }
    public void setKills(int kills) { this.kills = kills; }
    public void setDeaths(int deaths) { this.deaths = deaths; }
    public void setMatchesPlayed(int matchesPlayed) { this.matchesPlayed = matchesPlayed; }
}
