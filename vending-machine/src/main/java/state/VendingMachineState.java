package main.java.state;

import main.java.entity.Coin;
import main.java.entity.Product;

public interface VendingMachineState {
        void selectProduct(Product product);
        void insertCoin(Coin coin);
        void dispenseProduct();
        void returnChange();
     void cancelProduct();
    }


