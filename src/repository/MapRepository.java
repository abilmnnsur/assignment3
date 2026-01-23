package repository;

import model.MapStats;
import utils.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MapRepository {
    public List<MapStats> getMostPlayedMaps() {
        List<MapStats> result = new ArrayList<>();

        String sql = """
            SELECT m.map_name, COUNT(*) AS matches_count
            FROM matches ma
            JOIN maps m ON m.map_id = ma.map_id
            GROUP BY m.map_name
            ORDER BY matches_count DESC
        """;

        try (Connection conn = util.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                result.add(new MapStats(
                        rs.getString("map_name"),
                        rs.getInt("matches_count")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
