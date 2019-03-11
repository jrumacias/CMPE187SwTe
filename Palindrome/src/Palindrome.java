/**
 * Palindrome
 *
 * Original code written by: Juan Macias
 * San Jose State University
 * Spring 2019
 * CMPE187: Software Testing
 *
 * NOTES
 *  The following code:
 *      - Assumes palindromes to be valid for all alphanumeric combinations
 *      - Strips whitespace and non-alphanumeric characters from the input phrase
 */


public class Palindrome {
    private boolean isPalindrome;
    private int length;
    private int strippedLength;
    private String phrase;

    public Palindrome(String phrase) {
        this.isPalindrome = true;
        this.strippedLength = phrase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().length();
        this.phrase = phrase;
        this.length = phrase.length();
    }

    public boolean palindromeCheck() {
        // Remove non alphanumeric characters from string and convert to lowercase
        this.phrase = this.phrase.replaceAll("[^a-zA-Z0-9]", "");
        this.phrase = this.phrase.toLowerCase();

        int p1 = 0;
        int p2 = this.phrase.length()-1;

        while (p1 < p2) {
            if (this.phrase.charAt(p1) != this.phrase.charAt(p2)) {
                this.isPalindrome =  false;
            }
            p1++;
            p2--;
        }
        return this.isPalindrome;
    }

    public int getLength() {
        return this.length;
    }

}
