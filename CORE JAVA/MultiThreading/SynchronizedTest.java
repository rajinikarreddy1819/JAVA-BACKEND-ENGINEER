class Test{
    synchronized void m1(){
        System.out.println(" M1 ENTERED");
        try{
            Thread.sleep(2000);
        }
        catch(Exception e){

        }
        System.out.println("M1 OUTSIDE");
    }



synchronized void m2(){
    System.out.println(" M2 ENTERED");
    try{
        Thread.sleep(2000);
    }
    catch(Exception e){

    }
    System.out.println("M2 OUTSIDE");
}
}




public class SynchronizedTest {

public static void main(String [] args){
    Test t = new Test();
    Thread t1 = new Thread(() -> t.m1());
    Thread t2 = new Thread(() -> t.m2());
    t1.start();
    t2.start();

    }

}
