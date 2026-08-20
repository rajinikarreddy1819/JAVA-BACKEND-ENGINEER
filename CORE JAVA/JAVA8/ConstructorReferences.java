import java.util.Arrays;
import java.util.List;

class Student{
    String name;
    public Student(String _name){
        name = _name;
        System.out.println(name);
    }
}



public class ConstructorReferences {
    public static void main(String [] args){
        List<String> names = Arrays.asList("Krishna","Ram", "Hanuman", "Karna");
        names.forEach(Student::new); // Constructor Method References
    }


}
