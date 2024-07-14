/*
Prepared to deal with different user inputs
 */

import java.util.*;

public class Tools {
    private static Scanner input = new Scanner(System.in);
    //test private later

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        //see if there's next line
        while (input.hasNextLine()) {
            line = input.nextLine();

            if (line.length() == 0) {
                if (blankReturn) return line;//if blankReturn=true, it can be empty line
                else continue; //if blankReturn=false,it can't be empty
            }

            //the input has to be equal or smaller comparing to limit
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("Input length can't be bigger than " + limit +
                        ", please type again: ");
                continue;
            }
            break;
        }
        return line;
    }

   //read menu selection. It's supposed to be 1-5.
    public static char readSelection() {
        char c;
        for(;;) { //create an infinite loop
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
                System.out.print("Wrong selection. Please select again: ");
            } else {
                break;
            }
        }
        return c;
    }

    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(10, false);
            try {
                n = Integer.parseInt(str);//convert a String into an int
                break;
            } catch (NumberFormatException e) {
                System.out.print("Not an acceptable number. Please type again: ");
            }
        }
        return n;
    }

    public static int readInt(int defaultValue) {
        int n;
        for (;;) {
            String str = readKeyBoard(10, true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Not an acceptable number. Please type again: ");
            }
        }
        return n;
    }

    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("") ? defaultValue : str;
    }

    public static char readConfirmSelection() {
        System.out.println("Please type in your choice (y/n): ");
        char c;
        for (;;) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("Not an acceptable input. Please type again: ");
            }
        }
        return c;
    }
}
