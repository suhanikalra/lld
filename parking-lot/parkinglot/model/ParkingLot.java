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
        if (spotId == null || spotId.isBlank() || ticket.getVehicle() == null) {
            return false;
        }

        for (ParkingFloor parkingFloor : this.parkingFloors) {
            if (parkingFloor.unparkVehicle(ticket.getVehicle())) {
                return true;
            }
        }

        return false;
    }


    public ParkingLot(List<ParkingFloor> parkingFloors) {

        if (parkingFloors == null || parkingFloors.isEmpty()) {
            throw new IllegalArgumentException("Parking floors cannot be empty");
        }
        this.parkingFloors = parkingFloors;
    }

}