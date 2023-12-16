package CollectionFramework;

import java.util.*;

//Map is used to store key = value
public class TestMap {
    public static void main(String[] args){
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Smith",30);//put(key,value) enter a new pair, but if the key is existed, the original pair will be replaced and the push() return the original value
        map1.put("Anderson",31);
        map1.put("Mark",32);
        map1.put("Lewis",33);
        map1.put("Cook",34);
        Map<String, Integer> map2 = new HashMap<>();
        map2.putAll(map1);//put all the elements in map1 into map2
        map2.remove("Mark");//Remove the Mark:32 pair
        map1.forEach((e,c)->System.out.print(c+" "));//forEach is added as default, but map is not iterable
        Map<String, Integer> map3 = new LinkedHashMap<>(map2);//In LinkedHashMap, elements are ordered in insertion order or assess order
        //If we want to use access order create LinkedHashMap, we use LinkedHashMap(initialCapacity, loadFactor, true)
        Map<String, Integer> map4 = new TreeMap<>(map3);//TreeMap is sorted
        Map<Integer, Integer> map5 =new TreeMap<>(new myComparator());//We can use the new comparator to do different order
        Map<Integer, Integer> map6 =new TreeMap<>((i1,i2)->i1 - i2);

    }
    public static class myComparator implements Comparator<Integer>{
        public int compare(Integer o1, Integer o2){
              return 1;
        }
    }
}
