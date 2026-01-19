import model.Article;
import repository.ArticleRepository;
import service.TrendService;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ArticleRepository articleRepo = new ArticleRepository();
        TrendService trendService = new TrendService();

        System.out.println("=== ARTICLES ===");
        List<Article> articles = articleRepo.getAllArticles();
        for (Article a : articles) {
            System.out.println(a.getTitle() + " | " + a.getSource() + " | by " + a.getAuthorName());
        }

        System.out.println("\n=== TRENDING TAGS ===");
        Map<String, Integer> trends = trendService.getTrendingTags();
        for (String tag : trends.keySet()) {
            System.out.println(tag + " → " + trends.get(tag) + " articles");
        }
    }
}