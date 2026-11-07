package main.java;

import main.java.entity.*;
import main.java.state.VendingMachineState;
import main.java.state.IdleState;

public class VendingMachine {
    public void setCurrentState(VendingMachineState currentState) {
        this.currentState = currentState;
    }

    private Inventory inventory;

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    private int totalPayment;
    private Product selectedProduct;
    private int refundAmount;

    private VendingMachineState currentState;

    public int getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(int refundAmount) {
        this.refundAmount = refundAmount;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public VendingMachine(Inventory inventory) {
        this.inventory = inventory;
        this.totalPayment = 0;
        this.currentState = new IdleState(this);
        this.refundAmount=0;
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }
    public void cancel() {
        currentState.cancelProduct();
    }
}