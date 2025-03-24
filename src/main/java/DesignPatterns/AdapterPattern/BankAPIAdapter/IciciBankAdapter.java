package DesignPatterns.AdapterPattern.BankAPIAdapter;

import DesignPatterns.AdapterPattern.BankAPIs.ICICIBankApi;
import DesignPatterns.AdapterPattern.BankApi;

//To implement common method name implement BankApi. inside it call methods of respective bankapi cls
public class IciciBankAdapter implements BankApi {

    private ICICIBankApi iciciBankApi = new ICICIBankApi();

    @Override
    public int checkBalance() {
        return iciciBankApi.getBalance();
    }

    @Override
    public void transfer(int amount) {
        iciciBankApi.moneyTransfer(amount);
    }
}
