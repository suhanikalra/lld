package parkinglot.gates;

import parkinglot.model.ParkingLot;
import parkinglot.model.Ticket;
import parkinglot.model.TicketState;

import parkinglot.strategy.PricingStrategy;


import java.time.LocalDateTime;

public class ExitGate {
    private ParkingLot parkingLot;
    private PricingStrategy pricingStrategy;

    public ExitGate(ParkingLot parkingLot, PricingStrategy pricingStrategy) {
        if (parkingLot == null || pricingStrategy == null) {
            throw new IllegalArgumentException("Dependencies cannot be null");
        }
        this.parkingLot = parkingLot;
        this.pricingStrategy = pricingStrategy;
    }

    public double processExit(Ticket ticket, LocalDateTime exitTime) {
        if (ticket == null || exitTime == null ) {
            throw new IllegalArgumentException("Ticket and exit time cannot be null");
        }
        if(ticket.getTicketState() != TicketState.ACTIVE) {
            throw new IllegalArgumentException("Ticket state cannot be COMPLETED");

        }

        double fee = pricingStrategy.calculateFee(ticket, exitTime);

        boolean unparked = parkingLot.unparkVehicle(ticket);

        if (unparked) {
             ticket.markCompleted();
            System.out.println("Vehicle " + ticket.getVehicle().getVehicleNumber() +
                    " successfully unparked. Total Fee: ₹" + fee);
        } else {


            System.out.println("Failed to unpark vehicle. Spot might already be free.");
            throw new IllegalStateException("Failed to unpark vehicle");
        }

        return fee;
    }
}