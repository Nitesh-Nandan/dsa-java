package challenge;

import util.TestCaseUtil;

public class NumberOfOneBit {
    public static int numberOf1Bits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        tests();
    }

    static void tests() {
        TestCaseUtil.test(3, numberOf1Bits(7), 1);
        TestCaseUtil.test(0, numberOf1Bits(0), 2);
        TestCaseUtil.test(2, numberOf1Bits(5), 3);
    }
}
