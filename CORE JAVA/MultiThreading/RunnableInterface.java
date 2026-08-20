class RunnableClass implements Runnable {
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }

}

public class RunnableInterface  {
    public static void main(String [] args){
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        RunnableClass r = new RunnableClass();
        Thread t2 = new Thread(r);
        t1.start();
        try{
            System.out.println(" Thread 1 Is Going to Sleep .....");
            t1.sleep(5000);
            System.out.println("Thread 1 is in Activate State ....");
        }
        catch(Exception e){

        }
        t2.start();


    }

}
