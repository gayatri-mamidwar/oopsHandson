package DesignPatterns.AdapterPattern;

import DesignPatterns.AdapterPattern.BankAPIAdapter.IciciBankAdapter;
import DesignPatterns.AdapterPattern.BankAPIAdapter.YesBankApiAdapter;

//Based on user input we are creating obj so using Factory design pattern here
public class BankApiFactory {
    public static BankApi getBankApiByBankName(String bankName){
        BankApi bankApi = null;
        if(bankName.equalsIgnoreCase("YesBank")){
            bankApi = new YesBankApiAdapter();
        } else if(bankName.equalsIgnoreCase("ICICI")){
            bankApi = new IciciBankAdapter();
        }

        return bankApi;
    }
}
