import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String [] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(20,
                50,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5));
        for(int i=1; i<= 50; i++){
            int taskId = i;
            executor.execute(()->{
                System.out.println(" Task" + taskId + " Is Performed By" + Thread.currentThread().getName());
                try{
                    Thread.sleep(2000);
                }
                catch(Exception e) {
                    System.out.println("System is breakout");
                }

            });
        }
        executor.shutdown();

    }
}
