package LLDCaseStudy.ParkingLot.models;

import java.util.List;

public class ParkingFloor extends BaseClass {
    private  String number;
    private List<ParkingSlot> slots;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }

    public void setSlots(List<ParkingSlot> slots) {
        this.slots = slots;
    }
}
