package DesignPatterns.AdapterPattern;

//fasttagrecharge & billpayment to pay money
public class FastTagRecharge {
    public void recharge(int amount, BankApi bankApi){
        if(amount <= bankApi.checkBalance()){
            System.out.println("Successfully recharged ");
        } else{
            System.out.println("Insufficient Balance..");
        }
    }
}
