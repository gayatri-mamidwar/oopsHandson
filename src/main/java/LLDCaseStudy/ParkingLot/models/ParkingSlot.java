package LLDCaseStudy.ParkingLot.models;

//parkingLot is big, parkingSlot is small space of it
public class ParkingSlot extends  BaseClass {
    private String slotNumber;
    private ParkingSlotStatus parkingSlotStatus;
    //Only 1 type of vehicle on every slot
    private VehicleType vehicleType;

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
