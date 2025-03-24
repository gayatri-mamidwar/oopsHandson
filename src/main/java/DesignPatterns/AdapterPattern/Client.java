package DesignPatterns.AdapterPattern;

import java.util.Scanner;

public class Client {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("please enter the bank you want to use [Yesbank / ICICI] : ");
        String bankName = scanner.nextLine();

        BankApi bankApi = BankApiFactory.getBankApiByBankName(bankName);

        PhonePe phonePe = new PhonePe(bankApi);
        phonePe.rechargeFastTag(60);
    }
}
