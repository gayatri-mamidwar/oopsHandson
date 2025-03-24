package DesignPatterns.AdapterPattern;

public class BillPayment {
    public void recharge(int amount, BankApi bankApi){
        if(amount <= bankApi.checkBalance()){
            System.out.println("Successfully recharged");
        } else{
            System.out.println("Insufficient Balance..");
        }
    }
}
