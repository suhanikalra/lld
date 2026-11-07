package main.java.enums;

public enum VendingMachineState {
    IDLE,//select product
    READY,//coin inserted and validate payment
    DISPENSE,//give product and update inventory
    RETURNCHANGE //give money back
}
