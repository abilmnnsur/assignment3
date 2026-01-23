package service;

import exception.InvalidInputException;
import model.InventoryValue;
import repository.InventoryRepository;
import model.InventoryItem;

import java.util.List;

public class InventoryService {
    private final InventoryRepository repo = new InventoryRepository();

    public double getPlayerInventoryValue(int playerId) {
        return repo.getInventoryValueByPlayerId(playerId);
    }

    public List<InventoryValue> getTopInventories() {
        return repo.getTopInventories();
    }
    public List<InventoryItem> getPlayerInventory(int playerId) {
        if (playerId <= 0) {
            throw new InvalidInputException("Player ID must be positive");
        }
        return repo.getInventoryByPlayerId(playerId);
    }
}