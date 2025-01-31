package interfaces.stack;

import java.util.Scanner;

public class Client {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("which stack do u want to use?");
        String stackType = scanner.nextLine();
        Stack stack = StackFactory.createStackByType(stackType);
        stack.push(10);

    }
}
