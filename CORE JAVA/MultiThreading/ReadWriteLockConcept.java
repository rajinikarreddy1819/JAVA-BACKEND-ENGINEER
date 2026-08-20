
/*  ReadWriteLock ---> 1. readLock() (Shared Lock)
*                      2. writeLock()  (Exclusive Lock)
*  Multiple readers are allowed and only one writer is allowd at a time
*                        */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedResource{
    private int value =0;
    ReadWriteLock rwLock = new ReentrantReadWriteLock();
    Lock readLock = rwLock.readLock(); //Shared Lock
    Lock writeLock = rwLock.writeLock(); // Exclusive Lock
    public int read(){
        readLock.lock();
        try{
            try{
                Thread.sleep(2000);
            }
            catch(Exception e){

            }
            System.out.println(Thread.currentThread().getName() + " Reads " + value);
        return value;}

        finally{
            readLock.unlock();
        }
    }
    public void write (int val){
        writeLock.lock();
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
            writeLock.unlock();
        }

    }
}
public class ReadWriteLockConcept {

    public static void main(String [] args){
        SharedResource sr = new SharedResource();
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
