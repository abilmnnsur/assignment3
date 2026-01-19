import utils.util;
import java.sql.Connection;
import repository.TeamRepository;
import model.Team;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TeamRepository repo = new TeamRepository();
        List<Team> teams = repo.getAllTeams();

        for (Team t : teams) {
            System.out.println(t.getName() + " | " + t.getCountry() + " | rating: " + t.getTeamRating());
        }
    }
}