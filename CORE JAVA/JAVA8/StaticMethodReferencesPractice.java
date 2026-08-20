import java.util.Arrays;
import java.util.List;

public class StaticMethodReferencesPractice {
    public static void main(String [] args){
        List<String> names = Arrays.asList("Krishna","Ram", "Hanuman", "Karna");
        // names.forEach(name -> greet(name));
        names.forEach(StaticMethodReferencesPractice::greet); // Static Method References
    }
    public static void greet(String name){
        System.out.println("Hello, " + name);
    }
}
