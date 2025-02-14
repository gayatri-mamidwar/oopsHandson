package Concurrency_lab.WebScreapperMultiThreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
Callable takes little time to generate o/p but Runnable directly show o/p
 */

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<String> urls = new ArrayList<>();

        //create 100 URL's
        for(int i=0; i<100; i++){
            urls.add("http://example.com/page"+i);
        }

        //we need 2 executorService
        ExecutorService esFixed = Executors.newFixedThreadPool(10);
        ExecutorService esCached = Executors.newCachedThreadPool();

        long startTime = System.currentTimeMillis();
        executeWebScrapingCallable(urls, esFixed);      //declared this method as static
        long endTime = System.currentTimeMillis();
        System.out.println("Fixed Thread pool time -> Callable -> to scrap urls : " + (endTime-startTime));

        startTime = System.currentTimeMillis();
        executeWebScrapingCallable(urls, esCached);
        endTime = System.currentTimeMillis();
        System.out.println("Cached Thread pool time -> Callable -> to scrap urls : " + (endTime-startTime));

//        /* For Runnable-
//        long startTime = System.currentTimeMillis();
//        executeWebScrapingCallable(urls, esFixed);
//        long endTime = System.currentTimeMillis();
//        System.out.println("Fixed Thread pool time -> Runnable -> to scrap urls : " + (endTime-startTime));
//
//        startTime = System.currentTimeMillis();
//        executeWebScrapingCallable(urls, esCached);
//        endTime = System.currentTimeMillis();
//        System.out.println("Cached Thread pool time -> Runnable -> to scrap urls : " + (endTime-startTime));


    }

    //Callable method common logic (Sync)
    public static void executeWebScrapingCallable(List<String> urls, ExecutorService es) throws ExecutionException, InterruptedException {
        List<Future<Void>> futures = new ArrayList<>();

        for(String url: urls){
            futures.add(es.submit(new ScrapURLCallable(url)));
        }

        for(Future<Void> future : futures){
            future.get();                       //here, we r waiting for prev task to complete.then go to next task
        }
        return;
    }

    //Runnable method common logic (Async)
    public static void executeWebScrapingRunnable(List<String> urls, ExecutorService es){
        for(String url : urls){
            es.submit(new ScrapURLRunnable(url));   //in runnable without wait we move to next
        }
        return;
    }
}
