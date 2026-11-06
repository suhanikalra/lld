package parkinglot;

import parkinglot.gates.EntranceGate;
import parkinglot.gates.ExitGate;
import parkinglot.model.*;
import parkinglot.strategy.FixedPriceStrategy;
import parkinglot.strategy.HourlyPricingStrategy;
import parkinglot.strategy.PricingStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Create vehicles
        Vehicle car1 = new Vehicle("HR01AB1234", VehicleType.CAR);
        Vehicle car2 = new Vehicle("HR01AB5678", VehicleType.CAR);
        Vehicle bike1 = new Vehicle("HR01XY1234", VehicleType.BIKE);

        // 2. Create spots for floors
        ParkingSpot s1 = new ParkingSpot("S1", VehicleType.BIKE);
        ParkingSpot s2 = new ParkingSpot("S2", VehicleType.CAR); // Wait, make sure package/class name is ParkingSpot

        ParkingFloor floor1 = new ParkingFloor("Floor 1", List.of(s1));
        ParkingFloor floor2 = new ParkingFloor("Floor 2", List.of(s2));

        // 3. Create Parking Lot
        ParkingLot lot = new ParkingLot(List.of(floor1, floor2));

        // 4. Initialize Gates with Strategies
        EntranceGate entranceGate = new EntranceGate(lot);

        PricingStrategy hourlyStrategy = new HourlyPricingStrategy();
        ExitGate hourlyExitGate = new ExitGate(lot, hourlyStrategy);

        PricingStrategy fixedStrategy = new FixedPriceStrategy();
        ExitGate fixedExitGate = new ExitGate(lot, fixedStrategy);

        // 5. Test Entry Flow via EntranceGate
        Ticket ticket1 = entranceGate.markTicket(car1);
        Ticket ticket2 = entranceGate.markTicket(car2);
        Ticket ticketBike = entranceGate.markTicket(bike1);

        System.out.println("Car 1 Ticket (Spot S2): " + (ticket1 != null ? ticket1.getParkingSpot().getSpotId() : "Full"));
        System.out.println("Bike 1 Ticket (Spot S1): " + (ticketBike != null ? ticketBike.getParkingSpot().getSpotId() : "Full"));

        // 6. Test Exit & Fee Calculation Flow
        if (ticket1 != null) {
            LocalDateTime exitTime = ticket1.getEntryTime().plusHours(3);
            System.out.println("--- Processing Car 1 Exit (Hourly Strategy) ---");
            hourlyExitGate.processExit(ticket1, exitTime);
        }

        if (ticketBike != null) {
            LocalDateTime exitTime = ticketBike.getEntryTime().plusHours(2);
            System.out.println("--- Processing Bike 1 Exit (Fixed Price Strategy) ---");
            // fixed exit gate
            fixedExitGate.processExit(ticketBike, exitTime);
        }
    }
}