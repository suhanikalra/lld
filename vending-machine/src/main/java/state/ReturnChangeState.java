package main.java.state;

import main.java.VendingMachine;
import main.java.entity.Coin;
import main.java.entity.Product;

public class ReturnChangeState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine machine) {
        this.vendingMachine = machine;
    }

    @Override
    public void selectProduct(Product product){
        throw new IllegalStateException("Cannot select while returning change");
    }

    @Override
    public void insertCoin(Coin coin){
        throw new IllegalStateException("Cannot insert coin while returning change");

    }

    @Override
    public void dispenseProduct(){
        throw new IllegalStateException("Cannot dispense while returning change");

    }
    @Override
    public void returnChange() {
        int refund = vendingMachine.getRefundAmount();

        System.out.println("Returning amount: ₹" + refund);

        vendingMachine.setTotalPayment(0);
        vendingMachine.setSelectedProduct(null);
        vendingMachine.setRefundAmount(0);

        vendingMachine.setCurrentState(new IdleState(vendingMachine));
    }

    @Override
    public void cancelProduct(){
        throw new IllegalStateException("Cannot cancel while returning change");

    }
}
