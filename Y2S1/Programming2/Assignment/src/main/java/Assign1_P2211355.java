import java.util.Scanner;

class Objects{
    public String name;
    public String getName() {
        return this.name;
    }
    public void setName(String n){this.name = n;}
}
class DailyThings extends Objects{

}
class Ipad extends DailyThings{
    private int RAM = 4;
    private int ROM = 64;
    private double size = 10.0;
    private boolean activate = false;
    Ipad(){

    }
    //constructer
    Ipad(int RA, int RO, double s,  String nnn, boolean act){
        this.RAM = RA;
        this.ROM = RO;
        this.size = s;
        this.activate = act;
        this.name = nnn;
    }

    //getters

    public int getRAM(){
        return this.RAM;
    }
    public int getROM(){
        return this.ROM;
    }
    public double getSize(){
        return this.size;
    }

    public boolean getTheStatusOfIpad(){
        if(activate)
            System.out.println("The Ipad is on operating, Welcome");
        else
            System.out.println("The Ipad is not on operating");
        return this.activate;
    }
    //setters
    public void setRAM(int ram){
        this.RAM = ram;
    }
    public void setROM(int rom){
        this.ROM = rom;
    }
    public void setSize(int s){
        this.size = s;
    }

    public void setActivate(boolean ac){this.activate = ac;}

    public void turnOnIpad(){
        this.activate = true;
    }
    public void turnDownIpad(){
        this.activate = false;
    }
    //extra methods
    public void GuessingNum(){
        if(!activate) System.out.println("Ipad is not on operating");
        while(activate) {
            System.out.println("Begin your game please press 'b' or you exit the game");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            if (s.equals("b")) {
                int num = (int)(Math.random()*100);
                boolean isRight = false;
                int countTime = 0;
                while(!isRight){
                    System.out.println("Please enter a number between 0 and 100");
                    Scanner newScanner = new Scanner(System.in);
                    int guess = newScanner.nextInt();//This part can be improved by detecting whether the user enter a number or not, but I am lazy.
                    if(guess > num){
                        System.out.println("Big Guess");
                        ++countTime;
                    }
                    else if (guess < num){
                        System.out.println("Small Guess");
                        ++countTime;
                    }
                    else{
                        System.out.println("Congratulations ! Your answer is right :" + num);
                        System.out.println("Your count time is: " + countTime);
                        isRight = true;
                    }
                }
            } else {
                System.out.println("Exit.");
                break;
            }
        }

    }
    public void AInterestingQuestion(){
        System.out.println("There are 10 stairs, and you can only go 1 or 2 every time, how many ways can you get to the top?");
        Scanner newscanner = new Scanner(System.in);
        int guess = newscanner.nextInt();
        int p = 0, q = 0, r = 1;
        for(int i = 1; i <= 10; i++){
            p = q;
            q = r;
            r = p + q;
        }
        if(guess == r) System.out.println("You are right!");
        else System.out.println("You are wrong and the right answer is "+ r);
    }
}
public class Assign1_P2211355{
    public static void main(String[] args){
        Ipad ipad1 = new Ipad(8,256,11.0,"IPAD PRO 2077 IN PROGRESS",false);
        int a = ipad1.getRAM();
        System.out.println(a);
        int b = ipad1.getROM();
        System.out.println(b);
        String e = ipad1.getName();
        System.out.println(e);
        double f = ipad1.getSize();
        System.out.println(f);
        ipad1.turnOnIpad();
        boolean g = ipad1.getTheStatusOfIpad();
        System.out.println(g);
        ipad1.GuessingNum();
        ipad1.AInterestingQuestion();
    }
}
