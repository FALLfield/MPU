package AbtractAndInterface;

public class TestEdible{

}
abstract class Animal{
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract String sound();
}
class chicken extends Animal implements Edible{
    @Override
    public String howToEat(){
        return "Chicken: Fry";
    }
    @Override
    public String sound(){
        return "Chicken: jijiji";
    }

}
