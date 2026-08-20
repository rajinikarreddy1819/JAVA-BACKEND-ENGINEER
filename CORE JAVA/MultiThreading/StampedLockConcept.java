

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

class Resources{
    private int value =0;
    StampedLock lock = new StampedLock();
    public int read(){
        long stamp = lock.tryOptimisticRead();
        int currentValue = value;
        if(lock.validate(stamp) ==  false){
            // fallover logic
            // try pessimistic read
            stamp = lock.readLock();
            try{
                try{
                    Thread.sleep(1000);
                }
                catch(Exception e){

                }
                currentValue = value;
            }
            finally{
                lock.unlockRead(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName() + " Reads value as " + currentValue);
        return currentValue;

    }
    public void write (int val){
        long stamp = lock.writeLock();
        try{
            try{
                Thread.sleep(2000);
            }
            catch(Exception e){

            }

            value = val;
            System.out.println(Thread.currentThread().getName() + " Changes Value to " + value);

        }
        finally{
           lock.unlockWrite(stamp);
        }

    }
}
public class StampedLockConcept {

    public static void main(String [] args){
        Resources sr = new Resources();
        Thread r1 = new Thread(()-> {
            sr.read();
        });

        Thread r2 = new Thread(()-> {
            sr.read();
        });
        Thread r3 = new Thread(()-> {
            sr.read();
        });

        Thread w1 = new Thread(()-> {
            sr.write(10);
        });

        Thread w2 = new Thread(()-> {
            sr.write(11);
        });
        Thread w3 = new Thread(()-> {
            sr.write(12);
        });

        r1.start();
        r2.start();
        r3.start();
        w1.start();
        w2.start();
        w3.start();


    }


}
