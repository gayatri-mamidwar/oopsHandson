package DesignPatterns.AdapterPattern;

//ICICIBankApi & YesBankApi having diff method names. So taking BankApi as common interface. which having common method name for both
public interface BankApi {
    int checkBalance();
    void transfer(int amount);
}
