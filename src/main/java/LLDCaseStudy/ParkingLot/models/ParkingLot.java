package LLDCaseStudy.ParkingLot.models;

import java.util.List;

public class ParkingLot extends BaseClass {
    private String name;
    private ParkingLotStatus parkingLotStatus;
    private String address;
    private List<ParkingFloor> floors;
    private List<ParkingGate> gates;
    private int totalCapacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public List<ParkingGate> getGates() {
        return gates;
    }

    public void setGates(List<ParkingGate> gates) {
        this.gates = gates;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }
}
