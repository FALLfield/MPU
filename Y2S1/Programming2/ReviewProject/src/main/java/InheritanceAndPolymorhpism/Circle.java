package InheritanceAndPolymorhpism;

public class Circle extends GeometricObject{ //subclass
//One Java class can only be inherited from one parent class which is called single inheritance
    private double radius;
    private static int numberOfCircle;

    public Circle(double radius) {
        this.radius = radius;
        numberOfCircle++;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);//Allocate parent constructor with parameters
        //If we don't use super() or super(arguments), the super() will be used as the first statement in constructor
        //So if we want to build a parent class, we better build a non-parameter constructor to fit the need when sub constructor don't use super(arguments)
        this.radius = radius;
        numberOfCircle++;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return radius*radius*Math.PI;
    }
    public double getDiameter(){
        return 2 * radius;
    }
    public double getPerimeter(){
        return 2 * radius * Math.PI;
    }

    public void printCircle(){
        System.out.println("The circle is created "+ super.getDateCreated() + " and the radius is "+radius );
    }
    //We can also use super. to allocate methods in parent class

    //Method override
    @Override
    //With the @Override notation, we must override a method otherwise it will report error which is a compile error
    public String toString(){
        return super.toString() + "\nradius is " + radius;
    }
    //Only when parent method is accessible, we can overwrite it. If the parent method is private, the two methods have no relationship
    //@Override this report an error
    public static int getNumberOfGeo() {
        return numberOfCircle;
    }
    //It should be noticed that the static method can not be overrided
    //If we do that, the parent method will be hidden.
    //In this case, we can use SuperClassName.StaticMethodName to allocate hidden static method.

    //Method overload
    public void p(int i){
        System.out.println(i*2);
    }
    //overload means change the argument type of parent method. We can overload a method in subclass or in the same class

    public static void main(String[] args){
        Circle circle1 = new Circle(2);
        displayObject(circle1);
    }//Polymorhpism means parent variables can refer to sub variables

}
