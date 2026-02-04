package model;

import java.time.LocalDateTime;

public class CS2Article extends Article {

    private String source;

    public CS2Article(int articleId,
                      String title,
                      String content,
                      String authorName,
                      LocalDateTime publishedAt,
                      String source) {

        super(articleId, title, content, "CS2", authorName, publishedAt);
        this.source = source;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public String getCategory() {
        return "CS2 NEWS";
    }
}
