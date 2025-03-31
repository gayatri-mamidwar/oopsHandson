package DesignPatterns.StrategyPattern;

public class FarthestSlotAllocationStrategy implements SlotAllocationStrategy {
    @Override
    public int allocateSlot() {
        return 50;
    }
}
