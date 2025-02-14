package Concurrency_lab.MultithreadedSumCalculator;

import java.util.List;
import java.util.concurrent.Callable;

public class SumMultiThreadCallable implements Callable<Long> {

    //we need 3 things, input arr, startofChunk, endOfChunk. So,pass it in constructor
    List<Integer> arr;          //we r declaring here, in constructor we r initializing
    Integer start, end;

    public SumMultiThreadCallable(List<Integer> list, Integer start, Integer end){
        this.arr = list;
        this.start = start;
        this.end = end;
    }

    //task of single thread is to sum all elements present in 1 chunk
    @Override
    public Long call() throws Exception {
        Long sum = 0L;
        for(int i=start; i<end; i++){
            sum += arr.get(i);
        }
        return sum;
    }
}
