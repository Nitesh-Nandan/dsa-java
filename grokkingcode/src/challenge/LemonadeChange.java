package challenge;

public class LemonadeChange {
    public static boolean lemonadeChange(int[] bill) {
        int balance = 0;
        for (int amount : bill) {
            balance += 5;
            amount = amount - 5;
            if (balance < amount) {
                return false;
            } else {
                balance = balance - amount;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] bills = {5, 5, 5, 5, 20, 10, 10};
        System.out.println(lemonadeChange(bills));
    }
}
