import java.util.concurrent.CompletableFuture;

public class CompletableFutureConcept {
    // CompletableFuture uses Fork-Join Pool by default
    // Fork-join poll follows dviide and conquer which divides task into sub tasks
    // then it combines all sub tasks into main task
    public static void main(String [] args){
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10)
                .thenApply(result -> result * 2)
                .thenApply(result -> result * 3);
        CompletableFuture<Void> f2 = CompletableFuture.supplyAsync(() -> 10)
                .thenAccept(result -> System.out.println(result));
        try{
            System.out.println(f1.get());

        }
        catch(Exception e) {}

    }
}
