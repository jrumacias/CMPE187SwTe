public class Palindrome {

    public static boolean palindromeCheck(String s) {
        // Remove non alphanumeric characters from string and convert to lowercase
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();

        int p1 = 0;
        int p2 = s.length()-1;

        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(palindromeCheck("0P"));
    }
}
