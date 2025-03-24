package DesignPatterns.AdapterPattern.BankAPIAdapter;

import DesignPatterns.AdapterPattern.BankAPIs.YesBankApi;
import DesignPatterns.AdapterPattern.BankApi;

//Each Bank will have its own Adapter class
public class YesBankApiAdapter implements BankApi {

    private YesBankApi yesBankApi = new YesBankApi();

    @Override
    public int checkBalance() {
        return yesBankApi.balanceCheck();
    }

    @Override
    public void transfer(int amount) {
        yesBankApi.transferMoney(amount);
    }
}
