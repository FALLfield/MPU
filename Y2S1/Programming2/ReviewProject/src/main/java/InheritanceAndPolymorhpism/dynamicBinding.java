package InheritanceAndPolymorhpism;


public class dynamicBinding {
    public static void main(String[] args){
        Object o = new GeometricObject();
        System.out.println(o.toString());
        //Object is declared type and GeometricObject is actual type
        //o allocate actual type's method -- Dynamic Binding(Both the parent class and subclass have same method)

        m(new GraduateStudent());//Student
        m(new Student());//Student
        //The above statement equal to
        Object a = new Student();
        m(a);
        //We can always cast a sub instance to parent instance which is called upcasting
        //We use  Student a = (Student)a to downcasting a parent instance to sub instance
        if(a instanceof Student){
            Student b = (Student)a;
        }//Use instanceof to ensure the object is an instance of another object
        m(new Person());//Person
        m(new Object());//java.lang.Object@130c19b

        int age = 45;
        byte newAge = (byte)age;
        //Casting a basic type will return a new value

        Object aa = new Circle(1);
        Circle bb = (Circle) aa;
        //Casting an object won't create a new object
    }

    public static void m(Object x){
        System.out.println(x.toString());
    }

    public static void displayObject(Object object){
        if(object instanceof Circle){
            System.out.println(((Circle) object).getArea());
        }
    }//Different from dynamic binding, if the declared type is parent class, we must use above format to allocate sub method.
}
class GraduateStudent extends Student {

}
class Student extends Person{
    @Override
    public String toString(){
        return "Student";
    }
}
class Person{
    @Override
    public String toString(){
        return "Person";
    }

}
