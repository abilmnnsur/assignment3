package service;
import model.Team;
import repository.TeamRepository;

import java.util.List;

public class TeamService {

    private final TeamRepository repo = new TeamRepository();

    public List<Team> getTopTeams() {
        List<Team> teams = repo.getAllTeams();
        teams.sort((a, b) -> Double.compare(b.getTeamRating(), a.getTeamRating()));
        return teams;
    }
}