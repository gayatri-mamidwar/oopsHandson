package DesignPatterns.StrategyPattern;

public class NearestSlotAllocationStrategy implements  SlotAllocationStrategy {
    @Override
    public int allocateSlot() {
        return 1;
    }
}
