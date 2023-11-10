package Scanner;
import java.util.Scanner;

/**
 * A class that takes the java {@code Scanner} class and somewhat automates its
 * use.
 * 
 * @author Cedar Lehman
 */
public class TSI {
    private static Scanner stdIn;

    public static boolean promptBool(){
        return TSI.promptBool(null, null);
    }

    public static boolean promptBool(String prompt, String error){
        return (boolean) TSI.prompt(Boolean.class, prompt, error);
    }

    public static byte promptByte(){
        return TSI.promptByte(null, null);
    }

    public static byte promptByte(String prompt, String error){
        return (byte) TSI.prompt(Byte.class, prompt, error);
    }

    public static double promptDouble(){
        return TSI.promptDouble(null, null);
    }

    public static double promptDouble(String prompt, String error){
        return (double) TSI.prompt(Double.class, prompt, error);
    }

    public static float promptFloat(){
        return TSI.promptFloat(null, null);
    }

    public static float promptFloat(String prompt, String error){
        return (float) TSI.prompt(Float.class, prompt, error);
    }

    public static int promptInt(){
        return TSI.promptInt(null, null);
    }

    public static int promptInt(String prompt, String error){
        return (int) TSI.prompt(Integer.class, prompt, error);
    }

    public static long promptLong(){
        return TSI.promptLong(null, null);
    }

    public static long promptLong(String prompt, String error){
        return (long) TSI.prompt(Long.class, prompt, error);
    }

    public static short promptShort(){
        return TSI.promptShort(null, null);
    }

    public static short promptShort(String prompt, String error){
        return (short) TSI.prompt(Short.class, prompt, error);
    }

    public static String promptStr(){
        return stdIn.next();
    }

    private static Object prompt(Class<?> type, String prompt, String error){
        boolean valid = false; // is user entry a valid integer?
        Object x = null; // integer form of user entry

        TSI.stdIn = new Scanner(System.in);
        String xStr = stdIn.next();
        if(prompt != null){ System.out.print(prompt); }
        do{
            try{
                valid = false;
                switch(String.valueOf(type)){
                    case "class java.lang.Boolean":
                        x = Boolean.parseBoolean(xStr);
                        break;
                    case "class java.lang.Byte":
                        x = Byte.parseByte(xStr);
                        break;
                    case "class java.lang.Double":
                        x = Double.parseDouble(xStr);
                        break;
                    case "class java.lang.Float":
                        x = Float.parseFloat(xStr);
                        break;
                    case "class java.lang.Integer":
                        x = Integer.parseInt(xStr);
                        break;
                    case "class java.lang.Long":
                        x = Long.parseLong(xStr);
                    case "class java.lang.Short":
                        x = Short.parseShort(xStr);
                    default:
                        x = xStr;
                }
                valid = true;
            } catch (NumberFormatException e){
                if(error != null){ System.out.print(error); }
                xStr = stdIn.next();
            }
        } while (!valid);

        TSI.stdIn.close();
        return x;
    }
}