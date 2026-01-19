package model;

import java.time.LocalDateTime;

public class EsportsArticle extends Article {

    public EsportsArticle(int articleId, String title, String content,
                          String authorName, LocalDateTime publishedAt) {
        super(articleId, title, content, "ESPORTS", authorName, publishedAt);
    }

    @Override
    public String getSource() {
        return "Esports Global";
    }
}