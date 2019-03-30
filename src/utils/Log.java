package utils;

public class Log {

    public static String context = "DEBUG";

    public static void str(String string){
        if(context.equals("DEBUG")){
            System.out.print(string);
        }
    }

}
