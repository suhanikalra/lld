package main.java.entity;

public class Product {
    private final int price;
    private final String name;
    private final String category;

    public Product(String name,int price, String category) {
        this.price = price;
        this.category = category;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }




}
