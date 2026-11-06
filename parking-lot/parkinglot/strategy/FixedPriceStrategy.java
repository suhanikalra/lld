package parkinglot.strategy;

import parkinglot.model.Ticket;

import java.time.LocalDateTime;

public class FixedPriceStrategy implements PricingStrategy {
    @Override
    public double calculateFee(Ticket ticket, LocalDateTime exitTime){
        return 20.00;
    }


}
