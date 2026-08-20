
import java.util.function.*;
@FunctionalInterface  // Avoids the adding of another methods into functional interface
interface Car{
void drive();  // It must have  only one abstract method
    //  After java 1.8 we can add non abstract methods,
    //  private, static and non static Methods also

    default void honk(){

    }
    private void light(){

    }
    static void breaks(){

    }

}
class Audi implements Car{
    public void drive(){

    }
}



public class FunctionalInterfaceConcept {
    public static void main(String[] args){
        Car c = new Car(){
            public void drive(){
                System.out.print("Anonymous Class ");
            }

        };
        c.drive();

    }
}
