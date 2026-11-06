package parkinglot;

public class ParkingSpot {
    private String spotId;
    private VehicleType vehicleType;
    private Vehicle vehicle;
    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getSpotId() {
        return spotId;
    }


    public boolean isOccupied(){
        return vehicle != null;
    }

    public Boolean parkVehicle(Vehicle vehicle){
        if(vehicle == null || isOccupied() ||
                this.vehicleType != vehicle.getVehicleType()){
            return false;
        }
        this.vehicle=vehicle;
        return  true;
    }

    public boolean unparkVehicle(Vehicle vehicle){
        if (this.vehicle == null || this.vehicle != vehicle) {
            return false;
        }

        this.vehicle = null;
        return true;
    }

    public ParkingSpot( String spotId,VehicleType vehicleType) {
        if (spotId == null || spotId.isBlank()) {
            throw new IllegalArgumentException("Spot ID cannot be empty");
        }

        if (vehicleType == null) {
            throw new IllegalArgumentException("Vehicle type cannot be null");
        }

        this.vehicleType = vehicleType;
        this.spotId = spotId;

    }
}