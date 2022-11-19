package twopointers;

public class CompareStringWithBackSpace {
    public static void main(String[] args) {
        System.out.println(isEqual("xy#z".toCharArray(), "xzz#".toCharArray())); // true
        System.out.println(isEqual("xy#z".toCharArray(), "xyz#".toCharArray())); // false
        System.out.println(isEqual("xp#".toCharArray(), "xyz##".toCharArray())); // true
        System.out.println(isEqual("xywrrmp".toCharArray(), "xywrrmu#p".toCharArray())); // true
    }

    static boolean isEqual(char[] str1, char[] str2) {
        return true;
    }
}