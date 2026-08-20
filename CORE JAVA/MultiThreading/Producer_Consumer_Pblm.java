class Box {
    Integer item;
    boolean flag = false;
    void produce(int val){
        item = val;
        flag = true;
        System.out.println("Producer Produced and Place in Box:" + item);
    }

    void consume(){
        System.out.println("Consumer consumed item from Box:" + item);
        item = null;
        flag = false;
    }
}




public class Producer_Consumer_Pblm  {
    public static void main(String [] args) {

        Box b = new Box();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                b.produce(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
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
