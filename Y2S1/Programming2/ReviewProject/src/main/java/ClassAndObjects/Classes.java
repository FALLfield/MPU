package ClassAndObjects;

import java.util.Date;
import java.util.Random;

public class Classes {
    public static void main(String[] args){
        Date date1 = new Date();
        Random generator1 = new Random(3);
        System.out.print("Generator1: ");
        for(int i = 0; i < 10; i++){
            System.out.print(generator1.nextInt(100) + " ");
        }
        Random generator2 = new Random(3);
        System.out.print("Generator2: ");
        for(int i = 0; i < 10; i++){
            System.out.print(generator2.nextInt(100) + " ");
        }//With the same seed , two generator will generate same array.
    }
}
