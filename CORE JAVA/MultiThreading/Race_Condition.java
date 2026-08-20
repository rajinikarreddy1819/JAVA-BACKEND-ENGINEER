
class Problem{
    // Critical Section
    public int count = 0;
      void increment(){
        count++;  // It is Non atomic Operation (3 operations)
                  // 1. Read the count value
                  // 2. Increment the count +1
                  // 3. Update the Count value
    }
}

class Solution{
    // Critical Section

    public int count =0;  // Shared Resources
    synchronized void increment(){    // Lock is acquired by executing thread

        count++;
    }
    // When it completes the all  3 operations then Lock is released

}


public class Race_Condition  {

    public static void main(String [] args) throws InterruptedException{
        Problem p = new Problem();
        Thread t1 = new Thread(()->{
            for(int i=0; i<10000; i++){
                p.increment();
            }
        });
        Thread t2 = new Thread(()->{
            for(int i=0; i<10000; i++){
                p.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("================================================================================================");

        System.out.println("Race Condition occurs here because count shows less than 20000( Without Synchornization ):" + p.count);

        Solution s = new Solution();
        Thread t3 = new Thread(()->{
            for(int i=0; i<10000; i++){
                s.increment();
            }
        });
        Thread t4 = new Thread(()->{
            for(int i=0; i<10000; i++){
                s.increment();
            }
        });
        t3.start();
        t4.start();
        t4.join();
        t4.join();
        System.out.println("================================================================================================");
        System.out.println("Solution Of Race Condition is Using Synchornised.");
        System.out.println("By synchornization Method we can get count exactly (20000) : " + s.count);
        System.out.println("================================================================================================");


    }


}
