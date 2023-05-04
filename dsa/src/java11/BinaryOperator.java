package java11;

public class BinaryOperator {

    public static void main(String[] args) {
        int n = 32;

        while (n > 0) {
            if((n&1) == 1) {
                System.out.println("Bits found");
            } else {
                System.out.println("zero found");
            }
            n = n>>1;
        }
    }
}
