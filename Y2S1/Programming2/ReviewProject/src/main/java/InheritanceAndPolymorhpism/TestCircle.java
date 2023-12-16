package InheritanceAndPolymorhpism;

public class TestCircle extends B{
    public  TestCircle(){
        System.out.println("3C");
    }

    public static void main(String[] args){
        new TestCircle();
        Circle circle1 = new Circle(1);
        System.out.println("The circle is " + circle1.toString());
        System.out.println("The circle is " + circle1.getArea());

    }
}

class B extends  A{
    public B(){
        this("2b");
        System.out.print("3B");
    }
    public B(String b){
        System.out.println(b);
    }
}
class A{//The allocation order is according to inheritance list, 1A,2b,3B,3C
    public A(){
        System.out.println("1A");
    }
}
