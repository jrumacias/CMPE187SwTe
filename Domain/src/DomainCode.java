public class DomainCode {

    public static int codeDomain(int x, int y){
        int c, d, k;
        c = x * x;
        if(c > 25) {
            d = c - (x % 2);
        } else d = c + (x % 3);

        if(d >= c * 2) {
            k = x + (d * 2);
        } else k = y + (d / 4);

        return(k);
    }

    public static void main(String[] args) {
        System.out.println(codeDomain(5, 2));
    }
}
