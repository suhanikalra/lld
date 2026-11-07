package main.java.entity;

import main.java.enums.CoinType;

public class Coin {
    private final CoinType type;

    public Coin(CoinType type) {
        this.type = type;
    }

    public int getValue() {
        return type.getValue();
    }
}