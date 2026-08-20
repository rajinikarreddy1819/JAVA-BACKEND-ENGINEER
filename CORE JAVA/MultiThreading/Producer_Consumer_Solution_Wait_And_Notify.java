class Boxif {
    volatile Integer item;
    volatile boolean flag = false;
    synchronized void produce(int val) throws InterruptedException{
        while(flag == true){
                       // 1. Thread pauses it execution and saves point of execution in Program counter
            wait();   // 2. Releases the Monitors locks
                      // 3. Thread moves to  waiting state queue
                      // 4. Thread stays in queue untill any thread notifies it or wake up it
        }
        item = val;
        flag = true;
        System.out.println("Producer Produced and Place in Box:" + item);
        notify();  // 1. One Random thread is picked from waiting queue (It is non deterministic)
                   // 2. That Thread moves to Blocked State to acquire the lock
                   // 3. It will compete for lock to acquire
                   // 4. Thread will get lock finally
                   // 5. Thread moves to Runnable State
    }

    synchronized void consume() throws InterruptedException{

        while(flag == false){
            wait();
        }
        System.out.println("Consumer consumed item from Box:" + item);
        item = null;
        flag = false;
        notify();
    }
}




public class Producer_Consumer_Solution_Wait_And_Notify  {
    public static void main(String [] args) {

        Boxif b = new Boxif();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                    b.produce(i);
                } catch (InterruptedException e) {

                }

            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(70);
                    b.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        t1.start();
        t2.start();
    }

}
