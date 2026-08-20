import java.util.Arrays;
import java.util.List;

public class InstancesMethodReferences {
    public static void main(String [] args){
        // Created Instance for greet method
        InstancesMethodReferences instance = new InstancesMethodReferences();
        List<String> names = Arrays.asList("Krishna","Ram", "Hanuman", "Karna");
        // names.forEach(name -> greet(name));
        names.forEach(instance::greet); // Instance Method References
    }
    public  void greet(String name){
        System.out.println("Hello, " + name);
    }
}
