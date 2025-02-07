package IntroToThreads;

import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        Runnable runnable = new HelloWorld();
        System.out.println("Main thread: " + Thread.currentThread().getName());     // o/p-> Main thread: main
        //new HelloWorld().print();          //Without passing in Thread.it will consider in main thread //o/p-> Hello World from..main
        Thread thread = new Thread(runnable);
        thread.start();                         // o/p-> Hello World from..Thread-0
         */

        /*
        Thread t1 = new Thread(new PrintSum(3));
        t1.start();
         */

        /*
        //print every no. into a seperate thread
        int input = 10;
        for(int i=1; i<=10; i++) {
            Thread t2 = new Thread(new NumberPrinter(i));
            t2.start();
        } */

        //create Thread pool of fixed size. we r passing 5 as arg. so for printing only 5 threads are used
        ExecutorService executorService = Executors.newFixedThreadPool(5);  //here we have only 1 pool & only 5 threads..

        for(int i=1; i<=20; i++){
            executorService.execute(new NumberPrinter(i));
        }

        ExecutorService fibonacciExecutorService = Executors.newCachedThreadPool();
        Future<Integer> ansFuture = fibonacciExecutorService.submit(new FibonnaciNumber(3, fibonacciExecutorService));
        int ans = ansFuture.get();
        System.out.println("fib ans = " + ans);
    }
}


/* Thread programs-
1) print hello world
2) write a prog which calculate/print the sum from 1-100 in a seperate thread(only 1 thread)
3) print the sum 1-> N where N is input in a seperate thread(only 1 thread)
4) print the number from 1-> N but each in a seperate thread (Order doesn't matter)
 */