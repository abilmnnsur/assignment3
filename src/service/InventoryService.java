package service;

import model.InventoryValue;
import repository.InventoryRepository;

import java.util.List;

public class InventoryService {
    private final InventoryRepository repo = new InventoryRepository();

    public double getPlayerInventoryValue(int playerId) {
        return repo.getInventoryValueByPlayerId(playerId);
    }

    public List<InventoryValue> getTopInventories() {
        return repo.getTopInventories();
    }
}