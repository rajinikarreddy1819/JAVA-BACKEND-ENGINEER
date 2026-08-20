import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class Counter{
    public int count =0;
    void increment(){
        count++;   // It is non atomic operations means it is set of operations
                   // 1.read 2.increment 3. update
    }
}

class Counter1{
   //  public int count =0;
    AtomicInteger count = new AtomicInteger();  // It converts into Atomic Operation like one operation
    AtomicBoolean bool = new AtomicBoolean();

    void increment(){
        // count++;
        count.incrementAndGet();  // This will Read, increment and update the value
                                  // It works for both concurrent execution and parallel execution
    }
}





public class Lock_Free_Atomic_Members {
    public static void main(String [] args) {
        Counter c = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                c.increment();

            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                c.increment();

            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {

        }

        System.out.println("Count value Without use AtomicInteger: " +c.count);
        System.out.println("==============================================================");

        Counter1 c1 = new Counter1();
        Thread t3 = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                c1.increment();

            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                c1.increment();

            }
        });

        t3.start();
        t4.start();
        try {
            t3.join();
            t4.join();
        } catch (Exception e) {

        }

        System.out.println("Count value  using AtomicInteger: " +c1.count);

    }
}
