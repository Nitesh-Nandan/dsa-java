package twopointers;

public class CompareStringWithBackSpace {
    public static void main(String[] args) {
        System.out.println(isEqual("xy#z".toCharArray(), "xzz#".toCharArray())); // true
        System.out.println(isEqual("xy#z".toCharArray(), "xyz#".toCharArray())); // false
        System.out.println(isEqual("xp#".toCharArray(), "xyz##".toCharArray())); // true
        System.out.println(isEqual("xywrrmp".toCharArray(), "xywrrmu#p".toCharArray())); // true
    }

    static boolean isEqual(char[] str1, char[] str2) {
        int c1 = 0;
        int c2 = 0;

        for(int i=0;i<str1.length; i++) {
            if(str1[i] == '#') c1--;
            else {
                str1[c1++] = str1[i];
            }
        }

        for(int i=0;i<str2.length; i++) {
            if(str2[i] == '#') c2--;
            else {
                str2[c2++] = str2[i];
            }
        }
        if(c1 != c2) return false;

        for(int i=0; i<c1; i++) {
            if(str1[i] != str2[i]) return false;
        }
        return true;
    }
}
