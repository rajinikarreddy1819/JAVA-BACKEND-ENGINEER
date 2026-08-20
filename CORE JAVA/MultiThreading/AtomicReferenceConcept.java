import java.util.concurrent.atomic.AtomicReference;

class SeatBoooking{
    String seat = new String("EMPTY");
    boolean bookseat(String person){
        if(seat.equals("EMPTY")){
            seat = new String(person);
            return true;
        }
        return false;
    }
}
class SeatBooking_Sol{
    // String seat = new String("EMPTY")
    AtomicReference<String> seat = new AtomicReference<>("EMPTY");
    // Converting into single atomic operation (Single Operation)
    boolean bookseat(String name){
        String currentValue = seat.get();
        if(currentValue.equals("EMPTY") == false){
            return false;
        }
        /* if(seat.equals("EMPTY")){
            seat = new String(person);
            return true;
        }*/
        return seat.compareAndSet("EMPTY",name); // Converting into Atomic Operation
        // CAS (COMPARE AND SET) IT IS ATOMIC OPERATION (SINGLE OPERATION)
        // It avoids inconsistency occurs due to both concurrent and parallel


    }
}




public class AtomicReferenceConcept {
    public static void main(String [] args){
        SeatBoooking sb = new SeatBoooking();
        Thread t1 = new Thread(() -> {
            boolean bool = sb.bookseat("Rajinikar");
            if(bool){
                System.out.println(Thread.currentThread().getName() + "Person booked is (Without AtomicReferences) --->" + "Rajinikar");
            }
        });
        Thread t2 = new Thread(() -> {
           boolean bool =  sb.bookseat("Reddy");
            if(bool){
                System.out.println(Thread.currentThread().getName() + "Person booked is (Without AtomicReferences) ---> " + "Reddy");
            }
        });
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();

        }
        catch(Exception e){}
        SeatBooking_Sol sb1 = new SeatBooking_Sol();
        Thread t3 = new Thread(() -> {
           boolean bool =  sb1.bookseat("Rajinikar");
            if(bool){
                System.out.println(Thread.currentThread().getName() + "Person booked is (With AtomicReferences) ----> " + "Rajinikar");
            }
        });
        Thread t4 = new Thread(() -> {
           boolean bool =  sb1.bookseat("Reddy");
            if(bool){
                System.out.println(Thread.currentThread().getName() + "Person booked is (With AtomicReferences) ----> " + "Rajinikar");
            }
        });
        t3.start();
        t4.start();
        try{
            t3.join();
            t4.join();

        }
        catch(Exception e){}



    }
}
