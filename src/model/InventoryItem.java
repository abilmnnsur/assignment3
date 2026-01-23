package model;

public class InventoryItem {
    private final String weaponName;
    private final String skinName;
    private final String rarity;
    private final double price;
    private final int quantity;

    public InventoryItem(String weaponName, String skinName,
                            String rarity, double price, int quantity) {
        this.weaponName = weaponName;
        this.skinName = skinName;
        this.rarity = rarity;
        this.price = price;
        this.quantity = quantity;
    }

    public String getWeaponName() { return weaponName; }
    public String getSkinName() { return skinName; }
    public String getRarity() { return rarity; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}