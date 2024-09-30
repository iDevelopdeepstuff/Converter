/*
Greetings!

As per your recommendations, I somewhat improved the Converter:

1) Instead of mathematical formulas, I used Integer.toBinaryString(decimal) class and then looped
through the String using charAt(index) for a nicer display.
2) User should be able to enter any number of digits or characters , press Enter and An Error will be displayed
depending on the input, so the user may try again until the input matches the conditions (This part I had trouble so far over 2 hours
in trying to make it work). Basically I get a run time error "InputMismatchException". I tried to get input as String to be able to
display an error message when user inputs anything else than digits, without crashing, but that is the current challenge at hand.
3)Added Y/N prompt to either continue or exit the program. (User can input anything but only y or n are accepted,
that is what I want for point 2)
4)Thank you so much!
5) Feels weird to have more comments than code :)
 */

import java.util.Scanner;

public class DecToBinConverter {

    static String GREEN = "\u001B[1;32m"; // Adding more color to the console
    static String RESET = "\u001B[0m";

    public static void main(String[] args) {

        // control variable for program termination
        Scanner scan = new Scanner(System.in); // Creating Scanner Object
        System.out.println("This program converts decimals into binaries");
        String choice; // Y/N
        do { // loop until choice = n
            System.out.println("Enter the decimal: ");
            int decimal = scan.nextInt();
            String binary = Integer.toBinaryString(decimal); // very nice, less hassle
            int binaryLength = binary.length(); // // why not ^^
            System.out.println("Binary length : " + binaryLength);
            int rowsOf4 = 0; // variable to define a line of 4 elements before the newline for nicer output
            for (int index = 0; index < binaryLength; index++) { // printing individual characters from the obtained binary String
                System.out.print(GREEN + "\t" + binary.charAt(index) + RESET);
                rowsOf4++;
                if (rowsOf4 > 3) {
                    System.out.println();
                    rowsOf4 = 0;
                }
            }
            System.out.println("\nWish to proceed ? (Y/N): ");
            choice = scan.nextLine(); // will loop until user inputs 'y' or 'n', if 'y', then break from current loop and proceed again
                                      // if 'n', then break from outer loop to the end part
            while (!choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("y")) {
                System.out.println("Enter Y or N: ");
                choice = scan.nextLine();
                if (choice.equalsIgnoreCase("y")) break;
            }
        } while (!choice.equalsIgnoreCase("n"));

        System.out.println("Thank you for trying the program!" +
                "\nClosing the scanner and exiting.");
        scan.close(); // closing scanner, as per your recommendation
        System.exit(0);
    }
}



