
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



