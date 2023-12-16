package Generics;
//The main advantage of generics is testing errors when compiling
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class GenericStack<E> {
    //This E is a formal generic type, we can use an actual concrete type to change it. This process is called generic instantiation
    //Sometime, the generics class has multiple arguments, we should use <E1,E2,E3>.
    private java.util.ArrayList<E> list = new ArrayList<>();

    public GenericStack(){//The correct constructor of generics class

    }

    public int getSize(){
        return list.size();
    }
    public E peek(){
        return list.get(getSize()-1);
    }
    public void push(E o){
        list.add(o);
    }
    public E pop(){
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public String toString(){
        return "stack "+ list.toString();
    }
    public static void main(String[] args){
        Comparable<Date> c = new Date();
        //System.out.println(c.compareTo("red"));
        //This throw a compiling error since the compareTo need a Date variable
        ArrayList<String> l1 = new ArrayList<>();
        l1.add("red");//We can only add string in this list, and the generic type must be reference type
        //ArrayList<int> l2 = new ArrayList<>(); A compile error will be thrown we can use
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(5);//Java autobox the int type to Integer type
        int num1 = l2.get(0);//Java auto-unbox the Integer type to int type

        Integer[] l3 = {1,2,3,4,5};
        GenericStack.<Integer>print(l3);

        testClass2 t1 = new testClass2();
        testClass2 t2 = new testClass2();
        equalData(t1,t2);

        GenericStack s1 = new GenericStack();//Raw type, equals to GenericStack<Object> s1 = new GenericStack<Object>();
        //Raw type is not safe, we recommend generic type


    }

    public static <T> void print(T[] list){//We can declare a generics method in this format
    //<T> is equal to <T extends Object>
        for(int i = 0 ; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    public static <T extends testClass> boolean  equalData(T o1, T o2){//Bounded generic, must enter 2 testCLass instances.
        return o1.getData1() == o2.getData1();
    }//Since o1 and o2 must be testClass's instances, we can't invoke the testClass2's methods

    public static void printl(GenericStack<?> stack){//unbounded wildcard, <?> equals to <? extends Object>
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
    public static <T> void add(GenericStack<T> stack1, GenericStack<? super T> stack2){//lower-bounded wildcard
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }
    public static double max(GenericStack<? extends Number> stack){//bounded wildcard
        double max = stack.pop().doubleValue();//Initialize max

        while(!stack.isEmpty()){
            double value = stack.pop().doubleValue();
            if(value > max){
                max = value;
            }
        }
        return max;
    }
}
class testClass{
    private String name;
    private int data1;
    private int data2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getData1() {
        return data1;
    }

    public void setData1(int data1) {
        this.data1 = data1;
    }

    public int getData2() {
        return data2;
    }

    public void setData2(int data2) {
        this.data2 = data2;
    }
}
class testClass2 extends testClass{
    private int data3;

    public int getData3() {
        return data3;
    }

    public void setData3(int data3) {
        this.data3 = data3;
    }
}
