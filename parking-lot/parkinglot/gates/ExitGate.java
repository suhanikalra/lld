package parkinglot.gates;

import parkinglot.model.ParkingLot;
import parkinglot.model.Ticket;
import parkinglot.strategy.PricingStrategy;

import java.time.LocalDateTime;

public class ExitGate {
    private ParkingLot parkingLot;
    private PricingStrategy pricingStrategy;

    public ExitGate(ParkingLot parkingLot, PricingStrategy pricingStrategy) {
        this.parkingLot = parkingLot;
        this.pricingStrategy = pricingStrategy;
    }

    public double processExit(Ticket ticket, LocalDateTime exitTime) {
        if (ticket == null || exitTime == null) {
            throw new IllegalArgumentException("Ticket and exit time cannot be null");
        }

        double fee = pricingStrategy.calculateFee(ticket, exitTime);

        boolean unparked = parkingLot.unparkVehicle(ticket);

        if (unparked) {
            System.out.println("Vehicle " + ticket.getVehicle().getVehicleNumber() +
                    " successfully unparked. Total Fee: ₹" + fee);
        } else {
            System.out.println("Failed to unpark vehicle. Spot might already be free.");
        }

        return fee;
    }
}