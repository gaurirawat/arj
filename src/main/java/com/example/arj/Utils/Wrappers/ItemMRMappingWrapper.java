package com.example.arj.Utils.Wrappers;

public class ItemMRMappingWrapper {
    private int quantity;
    private int itemId;
    private int makeId;
    private int originId;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getMakeId() {
        return makeId;
    }

    public void setMakeId(int makeId) {
        this.makeId = makeId;
    }

    public int getOriginId() {
        return originId;
    }

    public void setOriginId(int originId) {
        this.originId = originId;
    }

    @Override
    public String toString() {
        return "ItemMRMappingWrapper{" +
                "quantity=" + quantity +
                ", itemId=" + itemId +
                ", makeId=" + makeId +
                ", originId=" + originId +
                '}';
    }
}
