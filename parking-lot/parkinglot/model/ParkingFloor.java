package parkinglot.model;

import java.util.List;

public class ParkingFloor {
    private String floorName;
    private List<ParkingSpot>  parkingSpots;
    public ParkingFloor(String floorName, List<ParkingSpot> parkingSpots) {
        this.floorName = floorName;
        this.parkingSpots = parkingSpots;

    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.parkVehicle(vehicle)) {
                return parkingSpot;
            }
        }
        return null;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.unparkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }
    public boolean unparkVehicle(String spotId) {
        if(spotId == null) {return false;}
        for (ParkingSpot parkingSpot : parkingSpots) {

            if (parkingSpot.getSpotId().equals(spotId)) {

                if (parkingSpot.isOccupied()) {
                    Vehicle vehicle = parkingSpot.getVehicle();
                    return parkingSpot.unparkVehicle(vehicle);
                }

                return false;
            }
        }

        return false;
    }

    public ParkingSpot getAvailableParkingSpot(Vehicle vehicle) {
        if(vehicle == null) {return null;}
        for (ParkingSpot parkingSpot : this.parkingSpots) {
            if (!parkingSpot.isOccupied()
                    && parkingSpot.getVehicleType() == vehicle.getVehicleType()) {
                return parkingSpot;
            }
        }
        return null;
    }
}