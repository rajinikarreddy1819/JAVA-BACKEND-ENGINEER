import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolConcept {
    public static void main(String [] args){
        int arr[] = {1,2,3,3,44,45};
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(arr,0,arr.length-1);
        int result =  pool.invoke(task);
        System.out.println(result);
        pool.shutdown();
    }


}
class SumTask extends RecursiveTask<Integer>{
    private int [] arr;
    private int start;
    private int end;
    public SumTask(int [] arr, int start, int end){
        this.arr = arr;
        this.start = start;
        this.end = end;
    }
    @Override
    protected  Integer compute(){

        //Base Condition
        if(end - start <= 2){
            int sum =0;
            for(int i= start; i<= end; i++){
                sum += arr[i];
            }
            return sum;
        }

        // Main Logic ---> Flork

        int mid = (start + end) /2;
        SumTask lefttask = new SumTask(arr, start, mid);
        SumTask righttask = new SumTask(arr, mid+1, end);
        lefttask.fork();
        // int sum1 = lefttask.compute();
        int sum2 = righttask.compute();
        int sum1 = lefttask.join();

        //Join
        return sum1 + sum2;



    }
}
