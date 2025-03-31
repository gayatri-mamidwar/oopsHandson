package DesignPatterns.StrategyPattern;

public class RandomSlotAllocationStrategy implements SlotAllocationStrategy {
    @Override
    public int allocateSlot() {
        return 20;
    }
}
