package Concurrency_lab.MultithreadedSumCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int n = 1000000;                    //1M arr size
        List<Integer> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            arr.add(i % 100);
        }

        //no.of.chunks(cores) or no.of threads both are same
        int noOfCores = Runtime.getRuntime().availableProcessors();       //gives no.of working cores currently
//        System.out.println(noOfCores);                                    //o/p-6

        ExecutorService es = Executors.newFixedThreadPool(noOfCores);

        /* for single thread ->
        //Task -> task
        // Future<Long> taskFuture = es.submit(task); //Processing already starts
        // Long result = taskFuture.get();
         */

        /*
        //let singlechunk size = 100000
        //i=0        start=0              end=100000
        //i=1        start=100000         end=200000
         */

        List<Future<Long>> sumFutures = new ArrayList<>();
        int singleChunkSize = n/noOfCores;

        //assign task to each core
        for(int i=0; i<noOfCores; i++){
//            SumMultiThreadCallable tempTask = new SumMultiThreadCallable(
//                                                        arr,
//                                                   i * singleChunkSize,
//                                                    (i + 1) * singleChunkSize);

            sumFutures.add(es.submit(new SumMultiThreadCallable(arr,i * singleChunkSize,(i + 1) * singleChunkSize)));
        }

        Long totalSum = 0L;
        //loop through each future & add sum
        for(Future<Long> future : sumFutures){
            totalSum += future.get();
        }

        System.out.println("sum of arr = "+totalSum);
    }
}
