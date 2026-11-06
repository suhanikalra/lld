package parkinglot.gates;

import parkinglot.model.ParkingLot;
import parkinglot.model.Ticket;
import parkinglot.model.Vehicle;

public class EntranceGate {
    ParkingLot parkingLot;
    public  EntranceGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket markTicket(Vehicle vehicle) {
        return parkingLot.parkVehicle(vehicle);
    }


}
