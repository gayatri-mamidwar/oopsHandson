package DesignPatterns.StrategyPattern;

public class ParkingLot {
    private SlotAllocationStrategy slotAllocationStrategy;

    public ParkingLot(SlotAllocationStrategy slotAllocationStrategy){
        this.slotAllocationStrategy = slotAllocationStrategy;
    }

    public void setSlotAllocationStrategy(SlotAllocationStrategy slotAllocationStrategy){
        this.slotAllocationStrategy = slotAllocationStrategy;
    }

    public String generateTicket(){
        int slot = slotAllocationStrategy.allocateSlot();
        return "TICKET-" + slot;
    }
}
