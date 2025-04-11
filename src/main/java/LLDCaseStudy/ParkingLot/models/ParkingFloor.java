package LLDCaseStudy.ParkingLot.models;

import java.util.List;

public class ParkingFloor extends BaseClass {
    private  int number;
    private List<ParkingSlot> slots;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }

    public void setSlots(List<ParkingSlot> slots) {
        this.slots = slots;
    }
}
