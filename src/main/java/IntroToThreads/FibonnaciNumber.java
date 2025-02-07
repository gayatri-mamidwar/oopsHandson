package IntroToThreads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonnaciNumber implements Callable<Integer> {
    int n;
    ExecutorService executorService;    //whenevr u want to available something for all service.pass in constructor

    FibonnaciNumber(int n, ExecutorService executorService){
        this.n = n;
        this.executorService = executorService;
    }

     /* Diff bet Runnable & Callable interface-
    Runnable -> uses execute() -> override run() -> not return anythng -> not take any parameter as i/p
    callable -> uses submit() -> override call() -> returns something -> not take any parameter as i/p
     */

    @Override
    public Integer call() throws Exception {
        System.out.println("Calculate " + n + "th Fib using Thread " + Thread.currentThread().getName());
        if(n <= 1){
            return n;
        }

        /* 2 tasks-
        1) find (n-1) fib
        2) find (n-2) fib
         */

        //it will create new pool for every recursive call.So,pass in constructor
        // ExecutorService executorService = Executors.newFixedThreadPool(2);

        // fib(7) -> thread 7
        // fib(6) -> thread 8
        // fib(5) -> thread 9

        //We need to wait for the o/p bcz callable return value
        Future<Integer> futureFirst = executorService.submit(new FibonnaciNumber(n-1, executorService));
        Future<Integer> futureSecond = executorService.submit(new FibonnaciNumber(n-2, executorService));

        //get of future.
        int x = futureFirst.get();
        int y = futureSecond.get();
        return x + y;
    }
}
