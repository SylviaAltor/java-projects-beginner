/*
Binary to decimal conversion, initial version.
*/

import java.util.*;

public class Conversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary or decimal number: ");
        String InputNum = input.next();

        Conversion convert = new Conversion();
        String outcome = convert.DecimaltoBinary(InputNum);

        System.out.println(InputNum + " is equal to " + outcome);
    }

    //method BinarytoDecimal
    public int BinarytoDecimal(String binary){
        int result = 0;
        int power = 1;

        for (int i = binary.length() - 1; i >= 0; i--) {
            //the length between '9' and '0' in ASCII is 9, so transfer to integer
            int number = binary.charAt(i) - '0';
            result += number * power;
            power *= 2;
        }

        return result;
    }
 
    //method DecimaltoBinary
    public String DecimaltoBinary(String decimal){
        int decimalNum = Integer.parseInt(decimal);
        String compose = "";
        String composeReverse = "";
        
        while (decimalNum != 0) {
        	int transfer = decimalNum % 2;
        	String str = String.valueOf(transfer);
        	compose += str;
        	decimalNum /= 2;
        }
        
        for (int i = compose.length() - 1; i >= 0; i--) {
        	composeReverse += compose.charAt(i);
        }
        
        return composeReverse;
    }
}
