package main.java.state;

import main.java.VendingMachine;
import main.java.entity.Coin;
import main.java.entity.Product;

public class ReadyState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine machine) {
        this.vendingMachine = machine;
    }

    @Override
    public void selectProduct(Product product){
        throw new IllegalStateException("Product already selected first");
    }

    @Override
    public void insertCoin(Coin coin){
        if(coin==null) throw new IllegalArgumentException("Coin cannot be null");

        vendingMachine.setTotalPayment(vendingMachine.getTotalPayment() + coin.getValue());
        if(vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getPrice()){
            vendingMachine.setRefundAmount(vendingMachine.getTotalPayment() - vendingMachine.getSelectedProduct().getPrice());
            vendingMachine.setCurrentState(new DispenseState(vendingMachine));
            vendingMachine.dispenseProduct(); // <-- ADDED: Automatically trigger dispense
        }
    }

    @Override
    public void cancelProduct(){
        if(vendingMachine.getSelectedProduct()==null)
            throw new IllegalArgumentException("Product cannot be null");
        vendingMachine.setRefundAmount(vendingMachine.getTotalPayment());
        vendingMachine.setCurrentState(new ReturnChangeState(vendingMachine));
        vendingMachine.getCurrentState().returnChange();
    }

    @Override
    public void dispenseProduct(){
        throw new IllegalStateException("Please insert coin ");
    }

    @Override
    public void returnChange(){
        throw new IllegalStateException("Please insert coin");
    }
}