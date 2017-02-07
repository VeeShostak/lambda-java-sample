/*
 * 
 */
package cokemachine;

import java.util.Scanner;

/**
 *
 * @author vladshostak
 */
public class CokeMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in); // input from keyboard
        // holds: nickel 5, dime 10, quarter 25
        int coinInput;
        int total = 0; // hold total coins inserted

        // hold drink names
        String drinkName[] = new String[3];
        // set drink names
        drinkName[0] = "Coke";
        drinkName[1] = "Coke Zero";
        drinkName[2] = "Caffeine Free Diet Coke";
        
        while (true) {

            while(total < 100) {
                System.out.println("Insert a coin: ");
                coinInput = input.nextInt();
                
                
                // if coin input correct accept, else reject
                if (coinInput == 5 || coinInput == 10 || coinInput == 25) {
                    total += coinInput;
                } else {
                    System.out.println("Rejecting " + coinInput + " coin");
                }
                System.out.println("Amount entered: " + total);
            }
            // once total >=100
            // make selection, error check selection
            do {
                System.out.println("Please make a selection:\n"
                + "1 - Coke\n" + "2 - Coke Zero\n" + "3 - Caffeine Free Diet Coke\n" 
                + "Your choice: ");
                coinInput = input.nextInt(); // stores the choice

                if (coinInput == 1) {
                    System.out.println("Your choice: 1\n" + "Dispensing " + drinkName[0]);
                } else if (coinInput == 2) {
                    System.out.println("Your choice: 2\n" + "Dispensing " + drinkName[1]);
                } else if (coinInput == 3) {
                    System.out.println("Your choice: 3\n" + "Dispensing " + drinkName[2]);
                } else {
                    System.out.println("Incorrect drink choice, try again\n");
                }
            } while(coinInput < 1 || coinInput > 3);

            total -= 100; // drink costs 100 cents

            // return all the change
            while (total != 0) {
                // return quarter
                if ( (total - 25) >= 0 ) {
                    total -= 25;
                    System.out.println("Returning quarter");               
                } else if ( (total - 10) >= 0 ) {
                    total -= 10;
                    System.out.println("Returning dime");               
                } else if ( (total - 5) >= 0 ) {
                    total -= 5;
                    System.out.println("Returning nickel");               
                } 
            }
            // reset for next iteration

        }
    } // end main
    
    
}
