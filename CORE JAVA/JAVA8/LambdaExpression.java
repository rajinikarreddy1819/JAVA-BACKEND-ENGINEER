@FunctionalInterface
interface  Cars{
    public void drive(int speed);
}
 class BMW  implements Cars{
    @Override
     public void drive(int s){
  System.out.println("IN BNW CLASS..");
    }
 }


public class LambdaExpression {
    public static void main(String[] args){
     Cars c = new Cars() {
         @Override
         public void drive(int s) {
             System.out.println("IN Anonymous C1");
         }
     };
     c.drive(100);
// Lambda Expression with anonymous Function
        Cars c2 = (speed) -> {
            if(speed>80) System.out.println("Avoid Rush Driving");
            System.out.println("IN Anonymous C2 ");
        };

        c2.drive(100);





    }


}
