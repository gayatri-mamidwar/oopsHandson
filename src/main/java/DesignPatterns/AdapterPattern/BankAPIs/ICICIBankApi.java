package DesignPatterns.AdapterPattern.BankAPIs;

//ICICIBankApi having its own API. & methods are getBalance(), moneyTransfer(int money)
public class ICICIBankApi {
    public int getBalance(){
        System.out.println("Checking the balance via ICICI Bank..");
        return 200;
    }

    public void moneyTransfer(int money){
        System.out.println("Money has been transfered via ICICI Bank Acc..");
    }
}
