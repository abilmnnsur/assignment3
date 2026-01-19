package repository;
import utils.util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MatchRepository {

    public List<String> getAllMatches() {
        List<String> matches = new ArrayList<>();

        String sql = """
            SELECT m.match_id, t1.name AS team1, t2.name AS team2,
                   m.team1_score, m.team2_score
            FROM matches m
            JOIN teams t1 ON m.team1_id = t1.team_id
            JOIN teams t2 ON m.team2_id = t2.team_id
        """;

        try (Connection conn = util.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String row = rs.getInt("match_id") + ": " +
                        rs.getString("team1") + " vs " +
                        rs.getString("team2") + " " +
                        rs.getInt("team1_score") + ":" +
                        rs.getInt("team2_score");
                matches.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matches;
    }
}