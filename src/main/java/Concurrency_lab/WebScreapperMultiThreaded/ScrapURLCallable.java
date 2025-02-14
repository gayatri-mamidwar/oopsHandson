package Concurrency_lab.WebScreapperMultiThreaded;

import java.util.concurrent.Callable;

public class ScrapURLCallable implements Callable<Void> {
    String url;

    public ScrapURLCallable(String url){
        this.url = url;
    }

    @Override
    public Void call() throws Exception {
//        System.out.println("Scraping website " + this.url);
        Thread.sleep(100);              //for me 200ms taking near about 3 min
        return null;
    }

}
