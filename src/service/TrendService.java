package service;
import utils.util;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class TrendService {
    public Map<String, Integer> getTrendingTags() {
        Map<String, Integer> trends = new LinkedHashMap<>();

        String sql = """
            SELECT t.name, COUNT(at.tag_id) AS usage_count
            FROM tags t
            JOIN article_tags at ON t.tag_id = at.tag_id
            GROUP BY t.name
            ORDER BY usage_count DESC
        """;

        try (Connection conn = util.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                trends.put(rs.getString("name"), rs.getInt("usage_count"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trends;
    }
}
