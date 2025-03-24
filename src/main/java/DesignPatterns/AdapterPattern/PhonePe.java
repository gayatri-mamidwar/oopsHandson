package DesignPatterns.AdapterPattern;

//Common cls. use this cls to call from client
public class PhonePe {
    private BankApi bankApi;
    private FastTagRecharge fastTagRecharge;
    private BillPayment billPayment;

    public PhonePe(BankApi bankApi){
        this.bankApi = bankApi;
        fastTagRecharge = new FastTagRecharge();
        billPayment = new BillPayment();
    }

    public void rechargeFastTag(int amount){
        fastTagRecharge.recharge(50, bankApi);
    }

    public void payBill(int amount){
        billPayment.recharge(100, bankApi);
    }


}
