package main.java.state;

import main.java.VendingMachine;
import main.java.entity.Coin;
import main.java.entity.Product;

public class IdleState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine machine) {
        this.vendingMachine = machine;
    }
    @Override
    public void selectProduct(Product product){
        if(vendingMachine.getInventory().isAvailable(product)){
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setCurrentState(new ReadyState(vendingMachine));

        }
        else throw new IllegalArgumentException("Product not available");
    }

    @Override
    public void insertCoin(Coin coin){
        throw new IllegalStateException("Please select a product first");

    }

    @Override
    public void dispenseProduct(){
        throw new IllegalStateException("Please select a product first");

    }
    @Override
    public void returnChange(){
        throw new IllegalStateException("Please select a product first");

    }

    @Override
    public void cancelProduct(){
        throw new IllegalStateException("Please select a product first");


    }
    }

