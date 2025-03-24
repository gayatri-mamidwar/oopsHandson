package DesignPatterns.AdapterPattern.BankAPIs;

//YesBankApi having its own API. & methods are balanceCheck(), transferMoney(int money)
public class YesBankApi {
    public int balanceCheck(){
        System.out.println("Checking the balance via Yes Bank..");
        return 200;
    }

    public void transferMoney(int money){
        System.out.println("Money has been transfered via Yes Bank Acc..");
    }
}
