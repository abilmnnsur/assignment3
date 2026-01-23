package repository;

import model.InventoryValue;
import utils.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryRepository {

    public double getInventoryValueByPlayerId(int playerId) {
        String sql = """
            SELECT COALESCE(SUM(pi.quantity * s.market_price), 0) AS total_value
            FROM player_inventory pi
            JOIN skins s ON s.skin_id = pi.skin_id
            WHERE pi.player_id = ?
        """;

        try (Connection conn = util.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, playerId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getDouble("total_value");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<InventoryValue> getTopInventories() {
        List<InventoryValue> result = new ArrayList<>();

        String sql = """
            SELECT p.nickname, SUM(pi.quantity * s.market_price) AS total_value
            FROM players p
            JOIN player_inventory pi ON pi.player_id = p.player_id
            JOIN skins s ON s.skin_id = pi.skin_id
            GROUP BY p.nickname
            ORDER BY total_value DESC
        """;

        try (Connection conn = util.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                result.add(new InventoryValue(
                        rs.getString("nickname"),
                        rs.getDouble("total_value")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}