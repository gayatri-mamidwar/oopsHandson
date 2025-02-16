package Concurrency_lab.BankAccountSynchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//THIS problem is same like adder subtractor......
//not getting final value as zero. bcz of Runnable. Use callable for waiting

public class Client {
    public static void main(String[] args) throws InterruptedException {

        BankAccount bankAccount = new BankAccount();
        ExecutorService es = Executors.newFixedThreadPool(10);


        //create 2 tasks i.e deposit & withdraw which will run seperately
        Runnable depositTask = () -> {
            for(long i=0; i<100; i++){
                bankAccount.deposit(i);
            }
        };

        Runnable withdrawTask = () -> {
            for (long i=0; i<100; i++){
                bankAccount.withdraw(i);
            }
        };

        // Submit tasks to the executor service
        for (int i = 0; i < 5; i++) {                  // 5 depositors and 5 withdrawers
            es.submit(depositTask);
            es.submit(withdrawTask);
        }

        es.shutdown();                      // It initiates the shutdown of tasks,
                                            //basically it doesn't except any new task
                                            //but waits for already assigned task to get over

        long startTime = System.nanoTime();

        // Submit tasks and wait for completion
        es.shutdown();
        if (!es.awaitTermination(2, TimeUnit.MINUTES)) {
            System.out.println("Some tasks are still running...");
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
        System.out.println("Execution time: " + duration + " ms");


        // Print final balance
        System.out.println("Final balance: " + bankAccount.getBalance());

    }
}
