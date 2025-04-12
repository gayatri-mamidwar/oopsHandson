package LLDCaseStudy.ParkingLot.repositories;

import LLDCaseStudy.ParkingLot.models.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {
    private Map<String, Vehicle> vehicleMap;
    private static int counter = 0;

    public VehicleRepository(){
        vehicleMap = new TreeMap<>();
    }

    public Optional<Vehicle> findVehicleByLicensePlate(String licensePlate){
        return Optional.ofNullable(vehicleMap.get(licensePlate));
    }

    public Vehicle save(Vehicle vehicle){
        counter++;
        vehicle.setId(counter);
        vehicleMap.put(vehicle.getLicensePlate(), vehicle);
        return vehicle;
    }
}
