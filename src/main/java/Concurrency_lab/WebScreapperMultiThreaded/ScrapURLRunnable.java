package Concurrency_lab.WebScreapperMultiThreaded;

public class ScrapURLRunnable implements Runnable {

    String url;
    public ScrapURLRunnable(String url){
        this.url = url;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
