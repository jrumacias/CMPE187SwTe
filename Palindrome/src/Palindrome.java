public class Palindrome {
    private boolean isPalindrome;
    private int length;
    private String phrase;

    public Palindrome(String phrase) {
        this.isPalindrome = true;
        this.length = phrase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().length();
        this.phrase = phrase;
    }

    public static void palindromeCheck(Palindrome p) {
        // Remove non alphanumeric characters from string and convert to lowercase
        p.phrase = p.phrase.replaceAll("[^a-zA-Z0-9]", "");
        p.phrase = p.phrase.toLowerCase();

        int p1 = 0;
        int p2 = p.phrase.length()-1;

        while (p1 < p2) {
            if (p.phrase.charAt(p1) != p.phrase.charAt(p2)) {
                p.isPalindrome =  false;
            }
            p1++;
            p2--;
        }
    }

    public static void main(String[] args) {
        Palindrome testPalindrome = new Palindrome("A man, a plan, a canal: Panama");

        System.out.println(testPalindrome.isPalindrome);
        System.out.println(testPalindrome.length);
    }
}
