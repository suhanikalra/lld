package parkinglot.strategy;

import parkinglot.model.Ticket;
import java.time.LocalDateTime;

public interface PricingStrategy {
      double calculateFee(Ticket ticket,LocalDateTime exitTime);
}
