class Person{
    private String first_name;
    private String last_name;

    Person(){

    }
    Person(String fn, String ln){
        this.first_name = fn;
        this.last_name = ln;
    }
    public String getFirst_name(){
        return this.first_name;
    }
    public String getLast_name(){
        return this.last_name;
    }
    public void setFirst_name(String fn){
        this.first_name = fn;
    }
    public void setLast_name(String ln){
        this.last_name = ln;
    }
    public void print(){
        System.out.println("He or she's name is "+ first_name+" "+last_name);
    }
}
class Student extends Person{
    private String studentId;
    Student(String fn, String ln, String di){
        setFirst_name(fn);
        setLast_name(ln);
        this.studentId = di;
    }
    Student(Person p, String di){
        setFirst_name(p.getFirst_name());
        setLast_name(p.getLast_name());
        this.studentId = di;
    }
    public String getStudentId(){
        return this.getStudentId();
    }
    public void print(){
        System.out.print("He or she's name and Id are: "+ getFirst_name()+" " + getLast_name()+" " +studentId);
    }
}
class Assignment2_P2211355{
    public static void main(String[] args){
        Person p1 = new Person("Tim", "Johnson");

        p1.print();

        System.out.println();     // print a blank line

        Student s1 = new Student(p1, "p1234567");

        s1.print();

        System.out.println();     // print a blank line

        Student s2 = new Student("Mary", "Brown", "p7654321");

        s2.print();
    }
}