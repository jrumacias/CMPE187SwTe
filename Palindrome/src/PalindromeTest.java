import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Palindrome Unit Test
 *
 * Original code written by: Juan Macias
 * San Jose State University
 * Spring 2019
 * CMPE187: Software Testing
 *
 * This class unit tests Palindrome.java.
 * In order to run assertions you must have JUnit 4 added to the classpath.
 */

public class PalindromeTest {

    @Test
    public void truePalindrome() throws IOException {
        /**
         * Checks that valied palindromes are properly flagged as true
         */
        ArrayList<String> validPhrases = oracle("valid_pals.txt");

        for (int i = 0; i < validPhrases.size(); i++) {
//            System.out.println("Testing phrase: " + validPhrases.get(i));
            Palindrome currentPalindrome = new Palindrome(validPhrases.get(i));
            assertEquals(true, currentPalindrome.palindromeCheck());
        }
    }

    @Test
    public void falsePalindrome() throws IOException {
        /**
         * Checks that invalid palindromes are properly flagged as false
         */
        ArrayList<String> validPhrases = oracle("invalid_pals.txt");

        for (int i = 0; i < validPhrases.size(); i++) {
//            System.out.println("Testing phrase: " + validPhrases.get(i));
            Palindrome currentPalindrome = new Palindrome(validPhrases.get(i));
            assertEquals(false, currentPalindrome.palindromeCheck());
        }

    }

    @Test
    public void palindromeLength() throws IOException {
        /**
         * Checks that valied palindromes are properly flagged as true
         */
        ArrayList<String> validPhrases = oracle("valid_pals.txt");

        for (int i = 0; i < validPhrases.size(); i++) {
//            System.out.println("Testing phrase: " + validPhrases.get(i));
            Palindrome currentPalindrome = new Palindrome(validPhrases.get(i));
            assertEquals(validPhrases.get(i).length(), currentPalindrome.getLength());
        }

    }

    // SET UP TESTING ENVIRONMENT

    private static ArrayList<String> oracle(String f) throws IOException {
        /**
         * This is our test oracle.
         * It generates random values to test
         *
         * @return random values to test.
         */
        String rootPath = "/Users/jmacias/IdeaProjects/CMPE187SwTe/Palindrome/";

        String file = rootPath + f;
//        System.out.println(f);

        ArrayList<String> validPhrases = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        while (currentLine != null) {
            validPhrases.add(currentLine);
            currentLine = reader.readLine();
        }

        return validPhrases;
    }
}
