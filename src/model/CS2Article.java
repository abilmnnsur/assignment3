package model;

import java.time.LocalDateTime;

public class CS2Article extends Article {

    public CS2Article(int articleId, String title, String content,
                      String authorName, LocalDateTime publishedAt) {
        super(articleId, title, content, "CS2", authorName, publishedAt);
    }

    @Override
    public String getSource() {
        return "Counter-Strike 2";
    }
}