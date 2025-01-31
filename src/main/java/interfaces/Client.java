package interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
//    private static Scanner scanner = new Scanner(System.in);        //cmdline i/p line should be above main method

    public static void main(String[] args) {

        Dog d = new Dog();
        RoboticDog r = new RoboticDog();

        Cat cat = new Cat();

        /* if u take List<Object> U can't restrict anyone to participate. Cat don't have run() then it can participate using Object type.
        So, to restrict we need interface. which allow only those participants who can run. */
        List<Object> participants = new ArrayList<>();
        participants.add(d);
        participants.add(r);
        participants.add(cat);

        List<Runner> runnerParticipants = new ArrayList<>();
        runnerParticipants.add(d);
        runnerParticipants.add(r);
       // runnerParticipants.add(cat);         //not allowed bcz cat is not implementing Runner interface. & we are taking List<Runner>
    }
}
