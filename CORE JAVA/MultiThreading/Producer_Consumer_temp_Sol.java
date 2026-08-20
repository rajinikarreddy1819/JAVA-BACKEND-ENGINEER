class Boxi {
    volatile Integer item;
    volatile boolean flag = false;
    void produce(int val){    // If use synchornization for these method then program will become deadlock
                              // If thread 2 executing the method consume without producing itam made program in lock
                              // (which thread 2 is waiting the resources which is in THread 1 executing it.
        while(flag == true){
            // do nothing
        }
        item = val;
        flag = true;
        System.out.println("Producer Produced and Place in Box:" + item);
    }

    void consume(){   // If use synchornization for these method then program will become deadlock
        // If thread 2 executing the method consume without producing itam made program in lock
        // (which thread 2 is waiting the resources which is in THread 1 executing it.

        while(flag == false){
            // do nothing
        }
        System.out.println("Consumer consumed item from Box:" + item);
        item = null;
        flag = false;
    }
}




public class Producer_Consumer_temp_Sol  {
    public static void main(String [] args) {

        Boxi b = new Boxi();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                b.produce(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(70);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                b.consume();
            }
        });
        t1.start();
        t2.start();
    }

}
