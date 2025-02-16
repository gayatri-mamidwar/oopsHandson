package Concurrency_lab.BankAccountSynchronized;

public class BankAccount {
    private Long balance = 0L;              //initialization is must. else u will get 'null' in o/p
    private final Object lock = new Object(); // Lock object for synchronization

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getBalance() {              //getter setter bcz at the end we want to check final balance value
        return balance;
    }

    // Add synchronized to Fix Race Conditions
    public void deposit(Long amount){
        synchronized (lock) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: " + amount + ", New Balance: " + balance);
            }
        }
    }

    public synchronized void withdraw(Long amount){
        synchronized (lock) {
            if (amount > 0 && balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
            } else {
                System.out.println("Insufficient balance for withdrawal: " + amount);
            }
        }
    }
}
