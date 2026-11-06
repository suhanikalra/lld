package parkinglot.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String name;
    private List<ParkingFloor> parkingFloors;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(ArrayList<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingFloor parkingFloor : this.parkingFloors) {

            ParkingSpot assignedSpot = parkingFloor.parkVehicle(vehicle);

            if (assignedSpot != null) {
                return new Ticket(vehicle, assignedSpot);
            }
        }

        return null;
    }

    public boolean unparkVehicle(Ticket ticket) {
        String spotId= ticket.getParkingSpot().getSpotId();
        if (spotId == null || spotId.isBlank()) {
            return false;
        }

        for (ParkingFloor parkingFloor : this.parkingFloors) {
            if (parkingFloor.unparkVehicle(spotId)) {
                return true;
            }
        }

        return false;
    }


    public ParkingLot(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

}