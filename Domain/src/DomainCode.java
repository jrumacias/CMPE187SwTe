public class DomainCode {

    public static int codeDomain(int x, int y){
        int c, d, k;
        c = (x * x) - y;
        if(c > 25) {                //OFF point closed
            d = c - (x / 4);
        } else d = c + (x / 4);     //OFF point open

        if(d >= y * 2) {            //ON point closed
            k = x + (d * 2);
        } else k = y + (d / 4);     //ON point open

        return(k);
    }

    public static void main(String[] args) {
        System.out.println(codeDomain(5, 2));
        System.out.println(26/4);
    }
}