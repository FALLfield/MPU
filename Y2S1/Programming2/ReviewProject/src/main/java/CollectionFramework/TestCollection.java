package CollectionFramework;

import java.util.*;
//Data structure is considered as a container, which is an Object that can contain other objects
//Java provide many data structures like list, vector, stack ,queue, set, map.... which is called Java Collection Framework

//collection is used to store a set of elements
//map is used to store key:value

//Set is used to store unduplicate elements
//List is used to store ordered elements
//Stack - FILO
//Queue - FIFO


public class TestCollection {
    public static void main(String[] args){
        ArrayList<String> collection1 = new ArrayList<>();
        collection1.add("New York");
        collection1.add("Atlanta");
        collection1.add("Dallas");
        collection1.add("Madison");

        Collection<String> collection2 = new ArrayList<>();
        collection2.add("Seattle");
        collection2.add("Portland");
        collection2.add("Log Angeles");
        collection2.add("Atlanta");

        System.out.println(collection1);//Print collection
        System.out.println("Is Dallas in collection1? " + collection1.contains("Dallas"));//return a boolean value
        collection1.remove("Dallas");//remove Dallas from collection1
        System.out.println("Collection1's size is " + collection1.size());//Return an int value
        ArrayList<String> c1 = (ArrayList<String>) (collection1.clone());//Copy a new collection from collection1, clone generates an Object instance
        c1.addAll(collection2);//add all the elements in collection2 to c1
        c1 = (ArrayList<String>) (collection1.clone());
        c1.retainAll(collection2);//retain all the elements both exist in c1 and collection2
        c1 = (ArrayList<String>) (collection1.clone());
        c1.removeAll(collection2);//remove all the elements exist in collection2

        Iterator<String> iterator1 = collection1.iterator();//Create an interator
        //Collection interface extends from Iterable interface, iterator() is defined in Iterable interface
        while(iterator1.hasNext()){//hasNext() judge if there is still elements existing
            System.out.print(iterator1.next()+" ");//get the next element
        }
        iterator1.remove();//remove the last element that next() access
        System.out.println();
        for(String element : collection1){//forEach loop
            System.out.println(element+ " ");
        }
        System.out.println();
        collection1.forEach(e -> System.out.print(e+" "));//forEach method is defined in Iterable interface
    }
}
