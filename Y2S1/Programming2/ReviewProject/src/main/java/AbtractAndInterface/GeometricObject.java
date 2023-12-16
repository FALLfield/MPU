package AbtractAndInterface;

import java.util.Date;

public abstract class GeometricObject { //Abstract class can not be used to create object
    private String color = "white";
    private boolean filled;
    final private java.util.Date dateCreated;
    private static int numberOfGeo = 0;

    protected GeometricObject(){
        dateCreated = new java.util.Date();
        numberOfGeo++;
    }//Only be used by its subclasses.

    protected GeometricObject(String color, boolean filled){
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

    public abstract double getArea();//Abstract methods are defined in abstract class, but they are implemented in actual classes.

    public abstract double getDiameter();
}

