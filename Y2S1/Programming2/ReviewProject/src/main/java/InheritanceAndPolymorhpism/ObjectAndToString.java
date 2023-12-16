package InheritanceAndPolymorhpism;

public class ObjectAndToString {
    //All the classes in Java is inheritated from Object class
    public static void main(String[] args){
        Testclass a = new Testclass(1);
        Testclass b = new Testclass(2);
        System.out.print(a.toString());
        //This toString return a String type: Testclass@1b6d3586 which is the class name, @, and the address
        //So we often override the toString method to give more useful information
        System.out.print(a);
        //This statement return the same result with a.toString()

        a.equals(b);//equals() is another method in Object class, which test if two objects are equal.

    }
    //The default format in Obejct class
    public boolean equals(Object o){
        return(this == o);
    }
    //Often we use "==", == can test two basic types, references. We try to override equals method to judge if two objects have same content
}
class Testclass{
    private int a;

    public Testclass(int a) {
        this.a = a;
    }
}
