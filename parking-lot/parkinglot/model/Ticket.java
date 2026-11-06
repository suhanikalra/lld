package parkinglot.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private ParkingSpot parkingSpot;
    private TicketState ticketState;

    public Vehicle getVehicle() {
        return vehicle;
    }


    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public TicketState getTicketState() {
        return ticketState;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
        this.ticketState=TicketState.ACTIVE;

    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void markCompleted(){
        if(this.ticketState!=TicketState.ACTIVE){
            throw new IllegalArgumentException("Ticket is not ACTIVE");
        }
        this.ticketState = TicketState.COMPLETED;
    }
}