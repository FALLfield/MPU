package InheritanceAndPolymorhpism;

import java.util.Date;

public class GeometricObject { //parent class
    private String color = "white";
    private boolean filled;
    final private java.util.Date dateCreated;

    private static int numberOfGeo = 0;

    public GeometricObject(){//The parent constructor can't be inheritated by subclass
        dateCreated = new java.util.Date();
        numberOfGeo++;
    }

    public GeometricObject(String color, boolean filled){
        this.color = color;
        this.filled = filled;
        dateCreated = new java.util.Date();
        numberOfGeo++;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public static int getNumberOfGeo() {
        return numberOfGeo;
    }

    public static void setNumberOfGeo(int numberOfGeo) {
        GeometricObject.numberOfGeo = numberOfGeo;
    }

    public String toString(){
        return "Created on " + dateCreated + "\ncolor: "+color+" and filled "+filled;
    }
    public void p(double i){
        System.out.print(i*2);
    }
    public static void displayObject(GeometricObject object){
        System.out.println(object);
    }

    private void printG(){
        System.out.print("The test of super");
    }//Super. can not allocate the private method in parent class


}
