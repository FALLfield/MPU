package CollectionFramework;
import AbtractAndInterface.GeometricObject;
import AbtractAndInterface.Circle;
//Using Comparable interface is called natural order
//Using Comparator interface is called using Comparator to compare


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestComparator {
    public static void main(String[] args){
        GeometricObject g1 = new Circle(5);
        GeometricObject g2 = new Circle(6);

        GeometricObject g = max(g1, g2, new GeometricObejctComparator());

        System.out.println("The bigger one's area is " + g.getArea());

        String[] cities = {"Atlanta", "Sacannah", "New York","Dallas"};
        java.util.Arrays.sort(cities,new MyComparator());
        //Or we can use Lambda expression
        //java.util.Arrays.sort(cities, (s1,s2) -> s1.length() - s2.length());
        //java.util.Arrays.sort(cities, (s1,s2) ->{return s1.length() - s2.length();});

        //Or we can use sort(comparator)
        List<String> cities2 = new ArrayList<String>(Arrays.asList(cities));
        cities2.sort((s1,s2) -> (s1.length() - s2.length()));
        //It should be noticed that sort() here is defined in Collection interface


        for(String s : cities){
            System.out.print(s+" ");
        }
        System.out.println();
    }
    public static GeometricObject max(GeometricObject o1, GeometricObject o2, Comparator<GeometricObject> c){
        if(c.compare(o1,o2) > 0){
            return o1;
        }else return o2;
    }
    public static class MyComparator implements java.util.Comparator<String>{
        @Override
        public int compare(String s1, String s2){
            return s1.length() - s2.length();
        }
    }//If we don't want to use natural order, we can override the compare to do sort()
}
class GeometricObejctComparator implements Comparator<GeometricObject>, java.io.Serializable{
    public int compare(GeometricObject o1, GeometricObject o2){
        double area1 = o1.getArea();
        double area2 = o2.getArea();

        if(area1 < area2) return -1;
        else if (area1 == area2) return 0;
        else return -1;
    }
}
