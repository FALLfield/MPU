package AbtractAndInterface;


public class Comparing extends Circle implements Comparable<Comparing> {
    public Comparing(double radius){
        super(radius);
    }
    @Override
    public int compareTo(Comparing o){
        if(getArea() > o.getArea()){
            return 1;
        }
        else if(getArea() == o.getArea()){
            return 0;
        }else return -1;
    }
    public static void main(String[] args){
        Comparing[] circles = {
                new Comparing(1),
                new Comparing(2),
                new Comparing(3),
                new Comparing(4),
        };
        java.util.Arrays.sort(circles);//sort()'s elements must implements comparable interface
    }
}
//When some classes don't implement comparbale interface, we can create a subclass which implement comparable interface
