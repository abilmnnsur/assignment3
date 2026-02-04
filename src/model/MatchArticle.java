package model;

import java.time.LocalDateTime;

public class MatchArticle extends Article {

    private String tournamentName;

    public MatchArticle(int articleId,
                        String title,
                        String content,
                        String authorName,
                        LocalDateTime publishedAt,
                        String tournamentName) {

        super(articleId, title, content, "MATCH", authorName, publishedAt);
        this.tournamentName = tournamentName;
    }

    @Override
    public String getSource() {
        return "Match Report";
    }

    @Override
    public String getCategory() {
        return "MATCH ANALYSIS";
    }
}
