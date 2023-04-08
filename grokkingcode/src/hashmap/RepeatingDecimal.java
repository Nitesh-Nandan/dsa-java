package hashmap;

import util.TestCaseUtil;

import java.util.HashMap;
import java.util.Map;

public class RepeatingDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if (numerator == 0) return "0";
        sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        long q = num / den;
        long r = num % den;
        sb.append(q);
        if (r == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> remPosMap = new HashMap<>();
        while (r != 0) {
            if (remPosMap.containsKey(r)) {
                sb.insert(remPosMap.get(r), "(");
                sb.append(")");
                break;
            } else {
                remPosMap.put(r, sb.length());
                r = r * 10;
                while (r < den) {
                    sb.append("0");
                    r = r * 10;
                }
                q = r / den;
                r = r % den;
                sb.append(q);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TestCaseUtil.test("3.424", fractionToDecimal(428, 125), 1);
        TestCaseUtil.test("13.(285714)", fractionToDecimal(93, 7), 2);
        TestCaseUtil.test("2", fractionToDecimal(4, 2), 3);
        TestCaseUtil.test("18.5", fractionToDecimal(37, 2), 4);
    }
}
