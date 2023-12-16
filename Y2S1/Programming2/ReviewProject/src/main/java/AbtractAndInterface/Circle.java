package AbtractAndInterface;

public class Circle extends GeometricObject{
    private double radius;

    public Circle(){

    }
    public Circle(double radius){
        this.radius = radius;
    }

    public double getArea(){
        return radius * radius * Math.PI;
    }
    public double getDiameter(){
        return radius * 2 * Math.PI;//We must implement the abstract methods otherwise there will be a compile error
    }
    //Just like dynamic binding, we choose actual type as the method

    //Notice
    //Abstract methods can't be included in non-abstract classes
    //Abstract class can't be initialized by new operator
    //Subclass can override parent class's methods and define them as abstract
    //Although a parent class is actual, the subclass can also be abstract

}
