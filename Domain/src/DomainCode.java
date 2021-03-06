/**
 * Domain Testing
 *
 * Original code written by: Juan Macias
 * San Jose State University
 * Spring 2019
 * CMPE187: Software Testing
 *
 * NOTES
 *  The following code:
 *      - Only accepts integer values for x, y inputs
 *      - Does not implement input validation
 */

public class DomainCode {

    public static int codeDomain(int x, int y) {
//        1. Initialize variables
        int c, d, k;
        System.out.println("Testing Point: (" + x + ", " + y + ")");
//        2. Assignment
        c = (x * x) - y;
        System.out.println("x^2 - y = c = " + c);
//        3. P1
        if(c > 25) {
//            4. Branch P1 = True
            d = c - (x / 4);
            System.out.println("P1: True");
        }
        else {
            d = c + (x / 4); // 5. Branch P1 = False
            System.out.println("P1: False");
        }
//        6. P2
        System.out.println("d = " + d);
        if(d >= c + 3) {
//            7. Branch P2 = True
            k = x + (d * 2);
            System.out.println("P2: True");
        } else {
            k = y + (d / 4); // 8. Branch P2 = False
            System.out.println("P2: False");
        }
//        9. Return Statement
        return(k);
    }

    public static void main(String[] args) {
        System.out.println("k = " + codeDomain(-15, 300));
    }
}