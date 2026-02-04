package repository;
import model.Team;
import utils.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamRepository {
    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        String sql = "SELECT team_id, name, country, team_rating FROM teams";

        try (Connection conn = util.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Team team = new Team(
                        rs.getInt("team_id"),
                        rs.getString("name"),
                        rs.getString("country"),
                        rs.getDouble("team_rating")
                );
                teams.add(team);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teams;
    }
}