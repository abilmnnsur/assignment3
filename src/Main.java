import model.Player;
import model.Team;
import repository.MatchRepository;
import service.PlayerService;
import service.TeamService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        TeamService teamService = new TeamService();
        PlayerService playerService = new PlayerService();
        MatchRepository matchRepo = new MatchRepository();

        System.out.println("=== TOP TEAMS ===");
        List<Team> teams = teamService.getTopTeams();
        for (Team t : teams) {
            System.out.println(t.getName() + " | rating: " + t.getTeamRating());
        }

        System.out.println("\n=== TOP PLAYERS ===");
        List<Player> players = playerService.getTopPlayers();
        for (Player p : players) {
            System.out.println(p.getNickname() + " | rating: " + p.getRating());
        }

        System.out.println("\n=== MATCHES ===");
        matchRepo.getAllMatches().forEach(System.out::println);
    }
}