
package parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;

public class FeeCalculator {

    public int getCostMultiplier(VehicleType vehicleType) {
        if (vehicleType == null) {
            throw new IllegalArgumentException("Vehicle type cannot be null");
        }

        if (vehicleType == VehicleType.CAR) {
            return 2;
        } else if (vehicleType == VehicleType.TRUCK) {
            return 3;
        } else {
            return 1;
        }
    }

    public double calculateFee(Ticket ticket, LocalDateTime exitTime) {

        if (ticket == null || exitTime == null) {
            throw new IllegalArgumentException("Ticket and exit time cannot be null");
        }

        LocalDateTime entryTime = ticket.getEntryTime();

        if (exitTime.isBefore(entryTime)) {
            throw new IllegalArgumentException("Exit time cannot be before entry time");
        }

        Duration duration = Duration.between(entryTime, exitTime);

        long minutes = duration.toMinutes();
        long hours = Math.max(1, (minutes + 59) / 60);

        Vehicle vehicle = ticket.getVehicle();

        int costMultiplier = getCostMultiplier(vehicle.getVehicleType());

        return hours * costMultiplier * 20.0;
    }
}
