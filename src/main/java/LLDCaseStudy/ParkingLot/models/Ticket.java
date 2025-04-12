package LLDCaseStudy.ParkingLot.models;

import java.util.Date;

//ticket will be given at entry So, it wont have exit time and bill
public class Ticket extends  BaseClass{
    private Date entryTime;
    private Vehicle vehicle;
    private Operator operator;
    private ParkingSlot parkingSlot;
    private ParkingGate gate;

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public ParkingGate getGate() {
        return gate;
    }

    public void setGate(ParkingGate gate) {
        this.gate = gate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "entryTime=" + entryTime +
                ", vehicle=" + vehicle +
                ", operator=" + operator +
                ", parkingSlot=" + parkingSlot +
                ", gate=" + gate +
                '}';
    }
}
