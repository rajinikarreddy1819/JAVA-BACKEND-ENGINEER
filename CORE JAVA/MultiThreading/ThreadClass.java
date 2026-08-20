

public class ThreadClass{
    public static void main(String [] args){
        MyThread t1 = new MyThread();
        t1.start();
        MyThread t2 = new MyThread();
        try{
            t2.sleep(4000);
            t1.join();
        }
        catch(Exception e){

        }
        t2.start();

        return;
    }

}


class MyThread extends Thread{

    public void run(){
        System.out.println("Thread...");
    }


}





