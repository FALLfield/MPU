package CollectionFramework;
import javafx.beans.binding.ObjectExpression;

import java.util.*;
import java.util.ArrayList;


public class ListTest {
    //ArrayList and LinkedList is defined under List interface which is extends from Collection interface
    public static void main(String[] args){
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(6);

        List<Integer> l2 = new ArrayList<>();
        l2.add(9);

        l1.add(0,0);//Add 0 at index 0
        l1.addAll(2,l2);//Add all elements of l2 at index 2
        List<Integer> l3 = l1.subList(3,5);//Return a new List<Integer> from index 3 to 5

        ListIterator<Integer> li1 = l1.listIterator();//return a listIterator
        li1.hasPrevious();//Detect if there is any element front
        li1.previous();//返回前一个元素
        li1.set(3);//Set() will change the element returned of next() and previous() to the pointed element

        LinkedList<Object> ll1 = new LinkedList<Object>(l1);//LinkedList is chosen when we need to insert or delete elements at the first index
        ll1.add(1, "red");
        ll1.removeLast();
        ll1.addFirst("green");

        String[] array = {"Apple", "Banana", "Orange"};
        // 将对象数组转换为ArrayList
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList(array));//Create a List from an Object array

    }
}
