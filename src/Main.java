import model.Article;
import model.Player;
import model.Team;
import repository.ArticleRepository;
import repository.MatchRepository;
import repository.PlayerRepository;
import repository.TeamRepository;
import service.PlayerService;
import service.TeamService;
import service.TrendService;
import utils.util;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // database qosylyp turma tekseremiz
        try (Connection conn = util.getConnection()) {
            System.out.println("Connected to database successfully!");
        } catch (Exception e) {
            System.out.println("Database connection failed:");
            e.printStackTrace();
            return;
        }

        // repositorlar
        TeamRepository teamRepository = new TeamRepository();
        PlayerRepository playerRepository = new PlayerRepository();
        MatchRepository matchRepository = new MatchRepository();
        ArticleRepository articleRepository = new ArticleRepository();

        // En qiyn metodtar or servicetar
        TeamService teamService = new TeamService();
        PlayerService playerService = new PlayerService();
        TrendService trendService = new TrendService();

        // Komandalar
        System.out.println("\n=== BARLYQ TEAMS ===");
        List<Team> teams = teamRepository.getAllTeams();
        for (Team t : teams) {
            System.out.println(t.getTeamId() + " | " + t.getName() + " | " +
                    t.getCountry() + " | rating: " + t.getTeamRating());
        }

        // Komandalardyn rating
        System.out.println("\n=== TOP TEAMS BY RATING ===");
        List<Team> topTeams = teamService.getTopTeams();
        for (Team t : topTeams) {
            System.out.println(t.getName() + " -> " + t.getTeamRating());
        }

        // Oiynshylar
        System.out.println("\n=== BARLYQ PRO IGROKTAR ===");
        List<Player> players = playerRepository.getAllPlayers();
        for (Player p : players) {
            System.out.println(
                    p.getPlayerId() + " | " +
                            p.getNickname() + " | team_id=" + p.getTeamId() +
                            " | rating=" + p.getRating()
            );
        }

        // Oiynshylar by rating
        System.out.println("\n=== EN UZDIK PLAYER BY RATING ===");
        List<Player> topPlayers = playerService.getTopPlayers();
        for (Player p : topPlayers) {
            double kd = playerService.calculateKD(p);
            System.out.println(p.getNickname() +
                    " | rating=" + p.getRating() +
                    " | KD=" + String.format("%.2f", kd));
        }

        // Matchtar
        System.out.println("\n=== MATCHES ===");
        List<String> matches = matchRepository.getAllMatches();
        for (String m : matches) {
            System.out.println(m);
        }

        // Zhanalyqtar
        System.out.println("\n=== ARTICLES ===");
        List<Article> articles = articleRepository.getAllArticles();
        for (Article a : articles) {
            System.out.println(
                    a.getArticleId() + " | " +
                            a.getTitle() + " | " +
                            a.getSource() + " | by " + a.getAuthorName()
            );
        }

        // HIT zhanalyqtar
        System.out.println("\n=== TRENDTEGI TAG ===");
        Map<String, Integer> trends = trendService.getTrendingTags();
        for (String tag : trends.keySet()) {
            System.out.println(tag + " -> " + trends.get(tag) + " articles");
        }

        // Sony
        System.out.println("\n=== BARLYQ NATIZHE SHYQTY ===");
    }
}