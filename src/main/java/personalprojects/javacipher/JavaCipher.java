package personalprojects.javacipher;

import java.util.Scanner;

/**
 *
 * @author JaNiah Harris
 * Email: janiah.harris205@gmail.com
 * Last updated: February 18, 2024 
 * The Cipher Program is an application designed to encrypt and decrypt text 
 * messages using substitution ciphers, offering both Shift and Vigenere ciphers.
 * 
 */
public class JavaCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to JaNiah Harris' cipher program!\n");

        char choice;
        do {
            System.out.println("Do you want to [E]ncrypt or [D]ecrypt?");
            choice = scanner.nextLine().toUpperCase().charAt(0);
        } while (choice != 'E' && choice != 'D');
        
        System.out.println("");

        char cipherType;
        do {
            System.out.println("Do you want to use a [S]hift cipher or a [V]igenere cipher?");
            cipherType = scanner.nextLine().toUpperCase().charAt(0);
        } while (cipherType != 'S' && cipherType != 'V');
        
        System.out.println("");

        Cipher cipher;
        if (cipherType == 'S') {
            System.out.println("Please enter a number between 0 and 25 to use as a key:");
            int key = Integer.parseInt(scanner.nextLine());
            cipher = new ShiftCipher(key);
        } else {
            System.out.println("Please enter a keyword:");
            String keyword = scanner.nextLine();
            cipher = new VigenereCipher(keyword);
        }
        
        System.out.println("");

        String inputText;
        if (choice == 'E') {
            System.out.println("Please enter the plaintext to be encrypted:");
            inputText = scanner.nextLine();
            String ciphertext = cipher.encrypt(inputText);
            System.out.println("The corresponding ciphertext is: " + ciphertext);
        } else {
            System.out.println("Please enter the ciphertext to be decrypted:");
            inputText = scanner.nextLine();
            String plaintext = cipher.decrypt(inputText);
            System.out.println("The corresponding plaintext is: " + plaintext);
        }
        
        System.out.println("");

        char continueChoice;
        do {
            System.out.println("Do you want to continue (Y/N)?");
            continueChoice = scanner.nextLine().toUpperCase().charAt(0);
        } while (continueChoice != 'Y' && continueChoice != 'N');
        
        System.out.println("");

        if (continueChoice == 'Y') {
            main(args); // Restart the program
        } else {
            System.out.println("\nThank you for using JaNiah Harris' cipher program.");
        }

        scanner.close();
    }
}
