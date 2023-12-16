package ErrorCatch;

public class ChainedExceptionDemo {
    public static void main(String[] args){
        try{
            method1();
        }
        catch (Exception ex){
            System.out.print("3");
            ex.printStackTrace();
        }

    }
    public static void method1() throws Exception{
        try{
            method2();
        }
        catch(Exception ex){
            System.out.print("a"+ex);
            throw new Exception("4");
        }

    }
    public static void method2() throws  Exception{
        throw new Exception("2");
    }
}
