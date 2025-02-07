package IntroToThreads;

public class PrintSum implements Runnable{
    int input;

    public PrintSum(int input){         //to take n as i/p from user
        this.input = input;
    }

    public void calSum() {
    int sum = 0;

        for(int i=1; i<=input; i++){
            sum += i;
        }
        System.out.println("Sum: " +sum + " Thread: " + Thread.currentThread().getName());  //to print only once i.e final o/p
    }


    @Override
    public void run() {
        //U want the input to be available here
        calSum();
    }
}
