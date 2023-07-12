package utils;

public class CommonMethods {

    public static void print(String string){
        System.out.println(string);
    }

    public static void holdOn(long seconds){
        try{
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            print(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
