package service;
import model.Player;
import repository.PlayerRepository;

import java.util.List;

public class PlayerService {

    private final PlayerRepository repo = new PlayerRepository();

    public List<Player> getTopPlayers() {
        List<Player> players = repo.getAllPlayers();
        players.sort((a, b) -> Double.compare(b.getRating(), a.getRating()));
        return players;
    }

    public double calculateKD(Player p) {
        if (p.getDeaths() == 0) return p.getKills();
        return (double) p.getKills() / p.getDeaths();
    }
    public List<Player> getKills(){
        List<Player> players = repo.getAllPlayers();
        players.sort((a, b) -> Double.compare(b.getKills(), a.getKills()));
        return players;

    }

}
