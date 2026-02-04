package model;

import core.Printable;
import core.Validatable;

import java.time.LocalDateTime;

public abstract class Article implements Printable, Validatable<Article> {

    protected int articleId;
    protected String title;
    protected String content;
    protected String type;
    protected String authorName;
    protected LocalDateTime publishedAt;

    public Article(int articleId,
                   String title,
                   String content,
                   String type,
                   String authorName,
                   LocalDateTime publishedAt) {

        this.articleId = articleId;
        this.title = title;
        this.content = content;
        this.type = type;
        this.authorName = authorName;
        this.publishedAt = publishedAt;
    }

    // ===== ABSTRACT METHOD =====
    public abstract String getSource();
    public abstract String getCategory();

    // ===== CONCRETE METHOD =====
    public String shortPreview() {
        return title + " by " + authorName + " [" + getCategory() + "]";
    }

    // ===== Printable =====
    @Override
    public String print() {
        return articleId + " | " + title + " | " + getSource();
    }

    // ===== Validatable =====
    @Override
    public void validate(Article obj) {
        Validatable.requireNonNull(obj.title, "title");
        Validatable.requireNonNull(obj.authorName, "authorName");
    }

    // ===== GETTERS =====
    public int getArticleId() { return articleId; }
    public String getTitle() { return title; }
    public String getType() { return type; }
    public String getAuthorName() { return authorName; }
}
