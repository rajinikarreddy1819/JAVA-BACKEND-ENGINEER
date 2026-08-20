interface Laptop{
    public void copy();
    void paste();
    // private void cut();
    public void cut();
    default void keyBoard(){
        System.out.println("I'M Inside of Interface and This Is Keyboard Feature Implemented Using Default access Modifier.");
    }
    static void security(){
        System.out.println("I'M Inside of Interface and This Is Security Feature Implemented Using static access Modifier.");

    }



}

class HP implements Laptop{
    public void copy(){
        System.out.println("HP Laptop Implemented Copy Function");
    }
    public void paste(){
        System.out.println("HP Laptop Implemented Paste Function");
    }
    public void cut(){
        System.out.println("HP Laptop Implemented Cut Function");
    }
       public void keyBoard(){
        System.out.println("HP Laptop Implemented Keyboard Function");
    }
    public static void security(){
        System.out.println("HP Laptop Implemented Its Own Security Function");
    }
    public void extrMethod(){
        System.out.println("We can add extra methods in class");
    }

}
class Lenovo implements Laptop{
    public void copy(){
        System.out.println("Lenovo Laptop Implemented Copy Function");
    }
    public void paste(){
        System.out.println("Lenovo Laptop Implemented Paste Function");
    }
    public void cut(){
        System.out.println("Lenovo Laptop Implemented Cut Function");
    }
    public void keyBoard(){
        System.out.println("Lenovo Laptop Implemented Keyboard Function");
    }
    public static void security(){
        System.out.println("Lenovo Laptop Implemented It Owns Security Function");
    }


}


public class InterfaceConcept  {
    public static void main(String[] args){
        HP hp = new HP();
        hp.copy();
        hp.cut();
        hp.paste();
        hp.keyBoard();
        HP.security();
        hp.extrMethod();
System.out.println("=======================================================");
        Lenovo l = new Lenovo();
        l.copy();
        l.cut();
        l.paste();
        l.keyBoard();
        Lenovo.security();
        Laptop ld = new Lenovo();
        ld.keyBoard();
    }
}
