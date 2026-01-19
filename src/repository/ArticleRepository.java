package repository;
import model.Article;
import model.CS2Article;
import model.EsportsArticle;
import utils.util;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();

        String sql = "SELECT article_id, title, content, type, author_name, published_at FROM articles";

        try (Connection conn = util.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("article_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String type = rs.getString("type");
                String author = rs.getString("author_name");
                LocalDateTime publishedAt = rs.getTimestamp("published_at").toLocalDateTime();

                Article article;
                if ("CS2".equals(type)) {
                    article = new CS2Article(id, title, content, author, publishedAt);
                } else {
                    article = new EsportsArticle(id, title, content, author, publishedAt);
                }

                articles.add(article);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articles;
    }
}
