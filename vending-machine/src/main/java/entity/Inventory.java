package main.java.entity;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<Product,Integer> quantity= new HashMap<>();

    public Map<Product, Integer> getQuantity() {
        return quantity;
    }

    public void addProduct(Product product, int q){
        if (q <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if(quantity.containsKey(product)){
            quantity.put(product,quantity.get(product)+q);
            return;
        }
        quantity.put(product,q);
    }
    public void removeProduct(Product product){
        if(quantity.containsKey(product)==false){
            throw new IllegalArgumentException("Product not found");
        }
        quantity.remove(product);
    }
    public int getQuantity(Product product) {
        return quantity.getOrDefault(product, 0);
    }
    public boolean reduceQuantity(Product product) {
        if (isAvailable(product)) {
            quantity.put(product, getQuantity(product) - 1);
            return true;
        }
        return false;
    }
    public boolean isAvailable(Product product){
        return getQuantity(product) > 0;

    }

}
