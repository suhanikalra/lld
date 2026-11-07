package main.java;

import main.java.entity.Coin;
import main.java.entity.Inventory;
import main.java.entity.Product;
import main.java.enums.CoinType;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize Inventory and Products
        Inventory inventory = new Inventory();
        Product cola = new Product("Cola", 15, "Beverage");
        Product chips = new Product("Chips", 10, "Snack");

        inventory.addProduct(cola, 3);
        inventory.addProduct(chips, 5);

        // 2. Initialize Vending Machine
        VendingMachine machine = new VendingMachine(inventory);
        System.out.println("--- Vending Machine Initialized (State: " + machine.getCurrentState().getClass().getSimpleName() + ") ---");

        // 3. Test a Successful Purchase
        System.out.println("\n[Test 1] Purchasing Cola (Price: ₹15)");
        System.out.println("Selecting Cola...");
        machine.selectProduct(cola);
        System.out.println("Current State: " + machine.getCurrentState().getClass().getSimpleName());

        System.out.println("Inserting ₹10 coin...");
        machine.insertCoin(new Coin(CoinType.TEN));

        System.out.println("Inserting ₹10 coin (Total: ₹20)...");
        // This coin will meet/exceed price and trigger auto-dispense & change return
        machine.insertCoin(new Coin(CoinType.TEN));

        System.out.println("Remaining stock for Cola: " + inventory.getQuantity(cola));
        System.out.println("Current State after cycle: " + machine.getCurrentState().getClass().getSimpleName());

        // 4. Test a Cancelled Transaction
        System.out.println("\n[Test 2] Cancelling a Transaction");
        System.out.println("Selecting Chips (Price: ₹10)...");
        machine.selectProduct(chips);
        System.out.println("Current State: " + machine.getCurrentState().getClass().getSimpleName());

        System.out.println("Inserting ₹5 coin...");
        machine.insertCoin(new Coin(CoinType.FIVE));

        System.out.println("Cancelling transaction...");
        machine.cancel(); // This will auto-refund and return to Idle
        System.out.println("Current State after cancel: " + machine.getCurrentState().getClass().getSimpleName());
    }
}