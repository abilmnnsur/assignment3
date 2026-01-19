import utils.util;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = util.getConnection()) {
            System.out.println("Connected to database successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}