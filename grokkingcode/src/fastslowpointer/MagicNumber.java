package fastslowpointer;

public class MagicNumber {
    public static void main(String[] args) {
        System.out.println(isHappyNumber(23)); // true
        System.out.println(isHappyNumber(12)); // false
    }

    static boolean isHappyNumber(int num) {
       return false;
    }

    static int calculateDigitSquareSum(int num) {
        int sum = 0;
        while (num != 0) {
            int rem = num%10;
            sum += (rem * rem);
            num /= 10;
        }
        return sum;
    }
}
