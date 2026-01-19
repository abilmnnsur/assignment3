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

        public int getPlayerId() {return playerId;}
        public int getTeamId() {return teamId;}
        public String getNickname() { return nickname; }
        public double getRating() { return rating; }
        public int getKills() { return kills; }
        public int getDeaths() { return deaths; }
        public int getMatchesPlayed() { return matchesPlayed; }
    }


