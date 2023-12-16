package ClassAndObjects;
//There are 4 visibility modifiers
//public: Can be accessed from every places
//protected: Can ve accessed from the same package or subclasses in other package
//default: without visibility modifiers, also called package-private, can be accessed from any class in the same package
//private: can be accessed in the same class

//If users try to access private data directly, it will cause compile error

public class TestCircle {
    public static void main(String[] args){
        Circle circle1 = new Circle();//The objects are instances of class
        //Objects are accessed by reference variable.
        Circle circle2;//Define a reference variable
        circle2 = new Circle(2.0);//Build an instance and pass its reference to variable

        int x;
        String y;
        //System.out.print(x + y);
        //The above statement will throw a NullPointerException which means we don't initialize the variable
    }
}
class Circle{//We can add two classes in the same file, but only the main class can be public, and the main class must has the same name with file.

    private double radius;//In most of the classes, the data field is private to avoid mis-change.
    private String name;//String is a reference type which default value is *null*
    //number type's default value is 0, boolean is false, char is \u0000

    private static int numberOfcircles;//static variables. Static variables store their values in a public address which means if we change the static variable value, all the instances will be influenced.
    //Static variables and methods can be accessed without building objects
    //Instance method and can access static methods and variables, also the instance methods and variables

    Circle(){//This is no-arg constructor.
        radius = 1;
        numberOfcircles++;
    }
    //When we don't define any constructors, Java will give a default constructor.
    Circle(double x){
        radius = x;
        numberOfcircles++;
    }//The construction method has three features:
    //has the same name with class name
    //No return type, even void
    //Allocate with new

    //public Circle(){
    //this(1.0);
    //}
    //this can be used to allocate another constructor


    public double getRadius(){
        return radius;
    }

    public double getArea(){
        return radius * radius * Math.PI;
    }//Access to the private data field

    public void setRadius(double radius) {
        this.radius = radius;
    }//Data field's radius is hidden by parameter radius, we use this.radius to refer to the data field name

    public static int getNumberOfcircles(){//If we want to access the static variables, we should use static method
        return numberOfcircles;
    }

    public static void printAreas(Circle c){//Java uses pass-by-value
        System.out.print(c.getRadius()+ " "+ c.getArea());
    }//We transfer reference copy in this method, but we can actually modify the value stored in referenced address.
}

//Immutable class
class Student{
    private String name;
    private int id;
    //All the data field is private
    public Student(int ssn, String newName){
        id = ssn;
        name = newName;
    }
    public int getId(){
        return id;
    }
    //No setters
    //No access method return a reference of mutable data field.
}

