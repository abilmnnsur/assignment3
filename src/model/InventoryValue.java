package model;

public class InventoryValue {
    private final String nickname;
    private final double totalValue;

    public InventoryValue(String nickname, double totalValue) {
        this.nickname = nickname;
        this.totalValue = totalValue;
    }

    public String getNickname() { return nickname; }
    public double getTotalValue() { return totalValue; }
}
