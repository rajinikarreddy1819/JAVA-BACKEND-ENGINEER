import java.util.concurrent.locks.*;


class Resource{
  Lock lock = new java.util.concurrent.locks.ReentrantLock();
  void f1() {
      lock.lock();
      try {
          System.out.println(Thread.currentThread().getName() + "  Entered...");
          try {
              Thread.sleep(2000);
          } catch (Exception e) {
          }
          System.out.println(Thread.currentThread().getName() + " Exited...");
      } finally {
          lock.unlock();
      }

  }
}



public class ReentrantLockConcept {

    public static void main(String [] args){
        Resource r = new Resource();
        Thread t1 = new Thread(() -> {r.f1();});

        Thread t2 = new Thread(() -> {r.f1();});
        Thread t3 = new Thread(() -> {r.f1();});
        t1.start();
        t2.start();
        t3.start();


    }
}
