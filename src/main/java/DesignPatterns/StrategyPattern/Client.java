package DesignPatterns.StrategyPattern;

import java.util.Scanner;

//Strategy design pattern is like dependency injection. same method is but with diff implementation.
public class Client {

    //Take scanner obj only once & use same obj everywhr
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hey! What is the Strategy you want to use Today ? ");
        String strategy = sc.nextLine();

        SlotAllocationStrategy slotAllocationStrategy =  SlotAllocationStrategyFactory.getSlotAllocationStrategy(strategy);

        ParkingLot parkingLot = new ParkingLot(slotAllocationStrategy);
        System.out.println(parkingLot.generateTicket());
    }
}
