public class DomainCode {

    public static int codeDomain(int x, int y){
        int c, d, k;
        c = x * x;
        if(c > 25) {
            d = c - (x / 4);
        } else d = c + (x / 4);

        if(d >= y * 2) {
            k = x + (d * 2);
        } else k = y + (d / 4);

        return(k);
    }

    public static void main(String[] args) {
        System.out.println(codeDomain(5, 2));
        System.out.println(26/4);
    }
}
