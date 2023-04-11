package challenge;

public class MinimumFlips {
    public static int minFlips(String str) {
        int len = str.length();
        str = str.concat(str);
        String tar1 = "";
        String tar2 = "";

        for (int i = 0; i < str.length(); i++) {
            tar1 = tar1.concat(i % 2 == 0 ? "0" : "1");
            tar2 = tar2.concat(i % 2 == 0 ? "1" : "0");
        }

        int diff1 = 0;
        int diff2 = 0;

        int ans = str.length();

        for (int i = 0; i < str.length(); i++) {
            if (tar1.charAt(i) != str.charAt(i)) {
                diff1++;
            }
            if (tar2.charAt(i) != str.charAt(i)) {
                diff2++;
            }
            if (i >= len) {
                if (tar1.charAt(i - len) != str.charAt(i - len)) {
                    diff1--;
                }
                if (tar2.charAt(i - len) != str.charAt(i - len)) {
                    diff2--;
                }
            }

            if (i >= len) {
                ans = Math.min(diff1, diff2);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        System.out.println(minFlips("110011011"));
    }
}
