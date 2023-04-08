package interviews;

public class PrimalTest2 {

    static int minCharToAddForPalindrome(String str) {
        if (str.length() < 2) return 0;
        int start = 0;
        int end = str.length() - 1;

        int ans = 0;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                ans++;
                start++;
            } else {
                start++;
                end--;
            }
        }

        return ans;
    }

    static int minCharToAddForPalindrome2(String str, int start, int end) {
        if (end - start < 1) return 0;
        int appendingLeft = 10000;
        int appendingRight = 10000;
        if (str.charAt(start) != str.charAt(end)) {
            appendingLeft = 1 + minCharToAddForPalindrome2(str, start, end - 1);
            appendingRight = 1 + minCharToAddForPalindrome2(str, start + 1, end);
        } else {
            return minCharToAddForPalindrome2(str, start + 1, end - 1);
        }
        return Math.min(appendingLeft, appendingRight);
    }

    // aba cccc aba =>

    // cc abacc   cc
    // ccabacc


    public static void main(String[] args) {
        test1();
    }

    static void test1() {
//        System.out.println(minCharToAddForPalindrome("abb"));
//        System.out.println(minCharToAddForPalindrome("ab"));
//        System.out.println(minCharToAddForPalindrome("xyz"));  //xyzyx
//        System.out.println(minCharToAddForPalindrome("abcda"));
//        System.out.println(minCharToAddForPalindrome("abcba"));
        System.out.println(minCharToAddForPalindrome("abacccc"));
        System.out.println(minCharToAddForPalindrome2("abacccc", 0, 6));
//        System.out.println(minCharToAddForPalindrome("ccabacccc"));
        System.out.println(minCharToAddForPalindrome2("ccabacccc", 0, 8));
    }
}
