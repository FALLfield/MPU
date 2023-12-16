import java.util.*;

public class Assign4_p2211355 {
    public static List<Integer> generateAndPrint(int n){
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int randomNumber = random.nextInt(21);
            numbers.add(randomNumber);
        }
        numbers.sort(Collections.reverseOrder());
        System.out.println(numbers);
        return numbers;

    }
    public static void getHash(List<Integer> numbers){
        Map<Integer, Integer> numberMap = new HashMap<>();
        for(int number : numbers){
            numberMap.put(number,numberMap.getOrDefault(number,0)+1);
        }
        Comparator<Integer> desComparator = Comparator.reverseOrder();
        TreeMap<Integer,Integer> ansMap = new TreeMap<>(desComparator);
        ansMap.putAll(numberMap);
        System.out.println(ansMap);
    }

    public static void rangCheck(int n){
        if(n < 1 || n > 100){
            throw new ArithmeticException();
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean continueInput = true;
        int n = 0;
        do{
            try{
                System.out.println("Please enter an integer from 1 to 100: ");
                int number = input.nextInt();
                rangCheck(number);
                System.out.println("n = "+ number);
                n = number;
                continueInput = false;
            }
            catch(InputMismatchException ex) {
                System.out.print("Not an integer. Please try again. ");
                input.nextLine();
            }
            catch(ArithmeticException ex){
                System.out.print("Out of range. Please try again. ");
                input.nextLine();
            }
        }while(continueInput);
        getHash(generateAndPrint(n));
    }
}
