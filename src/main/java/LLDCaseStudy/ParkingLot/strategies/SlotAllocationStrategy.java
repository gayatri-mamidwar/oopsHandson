package LLDCaseStudy.ParkingLot.strategies;

import LLDCaseStudy.ParkingLot.models.ParkingLot;
import LLDCaseStudy.ParkingLot.models.ParkingSlot;
import LLDCaseStudy.ParkingLot.models.VehicleType;

public interface SlotAllocationStrategy {
    ParkingSlot allocateSlot(ParkingLot parkingLot, VehicleType vehicleType);
}
