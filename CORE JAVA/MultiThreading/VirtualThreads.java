import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreads {
    public static void main(String [] args){
        Thread t1 = Thread.startVirtualThread(() -> {
           System.out.println(Thread.currentThread()+ "Says Hello") ;
        });
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        for(int i=0; i<10; i++){
            executor.submit(() ->{
                System.out.println("Task exected By " + Thread.currentThread());
            } );
        }
        try{
            Thread.sleep(3000);
        }
        catch(Exception e){

        }
 executor.shutdown();
    }
}
