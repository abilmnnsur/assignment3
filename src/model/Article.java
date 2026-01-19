package model;
import java.time.LocalDateTime;

public abstract class Article {
    protected int articleId;
    protected String title;
    protected String content;
    protected String type;
    protected String authorName;
    protected LocalDateTime publishedAt;

    public Article(int articleId, String title, String content, String type,
                   String authorName, LocalDateTime publishedAt) {
        this.articleId = articleId;
        this.title = title;
        this.content = content;
        this.type = type;
        this.authorName = authorName;
        this.publishedAt = publishedAt;
    }

    public abstract String getSource();

    public int getArticleId() { return articleId; }
    public String getTitle() { return title; }
    public String getType() { return type; }
    public String getAuthorName() { return authorName; }
}