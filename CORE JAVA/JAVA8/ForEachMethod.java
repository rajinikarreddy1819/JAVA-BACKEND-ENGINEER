import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachMethod {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,34,3,4,2);

        Consumer<Integer> con = new Consumer<Integer>() {
            public void accept(Integer integer) {
                System.out.print(integer + " ");
            }
        };
        // list.forEach(con);

        list.forEach(i -> {
            if(i % 2==0)
                System.out.println("It is even Number");
            else
                System.out.println("It is Odd Number");
        });

    }
}
