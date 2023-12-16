package CollectionFramework;
//Set is a data structure for storing and working with non-repeating elements

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {
    //Set interface doesn't add any new methods just regulate set is non-repeating
    //AbstractSet class extends from the AbstractCollection and implement Set interface
    public static void main(String[] args){
        Set<String> set1 = new HashSet<>();//The default container is 16 and load factor is 0.75

        set1.add("London");
        set1.add("Paris");
        set1.add("New York");
        set1.add("Beijing");
        set1.add("Paris");//2 Paris is added and set only contains one Paris, the HashSet is not ordered

        set1.forEach(e -> System.out.print(e + " "));//Set is iterable

        Set<String> set2 = new LinkedHashSet<>(set1);//We use set1 to create a new LinkedHashSet
        set2.forEach(e -> System.out.print(e + " "));//LinkedHashSet remains the insert order.
        //If we don't need order, HashSet is more efficient

        Set<String> set3 = new TreeSet<>(set2);//SortSet is a sub interface of Set, TreeSet implements the SortSet
        Set<Integer> set4 = new TreeSet<>();


    }
}
