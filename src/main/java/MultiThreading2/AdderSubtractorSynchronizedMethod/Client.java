package MultiThreading2.AdderSubtractorSynchronizedMethod;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Lock lock = new ReentrantLock();

        Value value = new Value();
        /* here, issue is that whenever we pass x at the tym of obj creation,it will create copy of x vari. it will not be a same x vari
        which u want to copy.So, in such case create class & pass its obj i.e reference so actual value is used instead of its copy */

        //pass value as reference
        //pass the same lock to both i.e Adder & Subtractor
        Adder adder = new Adder(value, lock);
        Subtractor subtractor = new Subtractor(value, lock);

        //create fixed thread pool of 2. bcz 1 thread for add & 1 for subtract
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //call & store future of Adder & subtractor
        Future<Void> adderFuture = executorService.submit(adder);
        Future<Void> subtractorFuture = executorService.submit(subtractor);

        //get value from future using get()
        adderFuture.get();
        subtractorFuture.get();

        System.out.println(value.getX());
    }
}
