package HW1;

import java.util.Scanner;

/**
 * Driver for generating strings that have the same statistical distribution of 
 * letters and spaces as a specified file.
 *   @author Dave Reed (edited by: Mason Anderson)
 *   @version 9/5/24
 */
public class ApproxDriver {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the file name: ");
        String filename = input.next();
        
        ApproxGenerator approx = new ApproxGenerator(filename);
        
        int desiredOrder = 0;
        
        while(true) {
        	System.out.println("Enter the desired order (>= 1): ");
            desiredOrder = input.nextInt();
            
            try {
            	approx.generate(desiredOrder, 0);
            	break;
            } catch (IllegalArgumentException e){
            	System.out.println(e.getMessage());
            }
        }   

        System.out.print("\nEnter the desired string length (negative to quit): ");
        int numChars = input.nextInt();
        
        
        while (numChars >= 0) {
            System.out.println(approx.generate(desiredOrder, numChars));
                    
            System.out.print("\nEnter the desired string length (negative to quit): ");
            numChars = input.nextInt();
        }  
        System.out.println("**DONE**");
        input.close();
    }
}
