package parkinglot.model;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Create vehicles
        Vehicle car1 = new Vehicle("HR01AB1234", VehicleType.CAR);
        Vehicle car2 = new Vehicle("HR01AB5678", VehicleType.CAR);
        Vehicle bike1 = new Vehicle("HR01XY1234", VehicleType.BIKE);

        // Create spots for Floor 1
        ParkingSpot s1 = new ParkingSpot("S1", VehicleType.BIKE);

        // Create spots for Floor 2
        ParkingSpot s2 = new ParkingSpot("S2", VehicleType.CAR);

        // Create floors
        ParkingFloor floor1 = new ParkingFloor(
                "Floor 1", List.of(s1)
        );

        ParkingFloor floor2 = new ParkingFloor(
                "Floor 2", List.of(s2)
        );

        // Create Parking Lot
        List<ParkingFloor> floors = List.of(floor1, floor2);
        ParkingLot lot = new ParkingLot(floors);

        // Test parking
        System.out.println("Car 1: " + lot.parkVehicle(car1));
        System.out.println("Car 2: " + lot.parkVehicle(car2));
        System.out.println("Bike 1: " + lot.parkVehicle(bike1));

        // Test unpark
        System.out.println("Unpark S2: " + floor2.unparkVehicle("S2"));
        System.out.println("Unpark S2 again: " + floor2.unparkVehicle("S2"));
        System.out.println("Unpark S1: " + floor1.unparkVehicle("S1"));
    }
}