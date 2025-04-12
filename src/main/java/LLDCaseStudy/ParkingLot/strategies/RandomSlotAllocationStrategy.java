package LLDCaseStudy.ParkingLot.strategies;

import LLDCaseStudy.ParkingLot.models.*;

public class RandomSlotAllocationStrategy implements SlotAllocationStrategy {

    @Override
    public ParkingSlot allocateSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        for(ParkingFloor pf : parkingLot.getFloors()){
            for(ParkingSlot ps : pf.getSlots()){
                if(ps.getParkingSlotStatus().equals(ParkingSlotStatus.EMPTY) && ps.getAllowedVehicleType().equals(vehicleType)){
                    return ps;
                }
            }
        }

        return null;
    }
}
