package main.java.state;

import main.java.VendingMachine;
import main.java.entity.Coin;
import main.java.entity.Inventory;
import main.java.entity.Product;

public class DispenseState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine machine) {
        this.vendingMachine = machine;
    }

    @Override
    public void selectProduct(Product product){
        throw new IllegalStateException("DispenseState can't select a product");
    }

    @Override
    public void insertCoin(Coin coin){
        throw new IllegalStateException("DispenseState can't insert coin");
    }

    @Override
    public void dispenseProduct(){
        if(vendingMachine.getSelectedProduct()==null)
            throw new IllegalArgumentException("Product cannot be null");

        Product product = vendingMachine.getSelectedProduct();
        Inventory inventory = vendingMachine.getInventory();

        if(inventory.isAvailable(product)){
            inventory.reduceQuantity(product);
            vendingMachine.setRefundAmount(vendingMachine.getTotalPayment() - product.getPrice());
            vendingMachine.setCurrentState(new ReturnChangeState(vendingMachine));
            vendingMachine.getCurrentState().returnChange();
        }
        else {
            vendingMachine.setRefundAmount(vendingMachine.getTotalPayment());
            vendingMachine.setCurrentState(new ReturnChangeState(vendingMachine));
            vendingMachine.getCurrentState().returnChange();
            throw new IllegalStateException("Product is out of stock");
        }
    }

    @Override
    public void returnChange(){
        throw new IllegalStateException("DispenseState can't return change");
    }

    @Override
    public void cancelProduct(){
        throw new IllegalStateException("Cannot cancel while dispensing");
    }
}