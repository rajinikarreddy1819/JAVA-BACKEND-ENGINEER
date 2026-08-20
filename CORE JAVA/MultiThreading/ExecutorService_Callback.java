import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorService_Callback {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = executor.submit(() -> {
            try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        return 10;});

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }

        try {
            System.out.println(f1.get());
        } catch (Exception e) {

        }
        executor.shutdown();

    }
}

