package binarysearch;

import util.TestCaseUtil;

public class AllocateBooks {
    public static int maxPageForBooks(int[] books, int student) {
        if (student > books.length) return -1;
        int high = 0;
        for (int page : books) {
            high += page;
        }
        int ans = 0;
        int low = 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canAllocate(books, mid, student)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean canAllocate(int[] books, int limit, int student) {
        int rs = 1;
        int pageSum = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] > limit) {
                return false;
            }
            if (pageSum + books[i] > limit) {
                pageSum = books[i];
                rs++;
                if (rs > student) {
                    return false;
                }
            } else {
                pageSum += books[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        int[] books = new int[]{12, 34, 67, 90};
        TestCaseUtil.test(113, maxPageForBooks(books, 2), 1);
    }

    private static void test2() {
        int[] books = new int[]{73, 58, 30, 72, 44, 78, 23, 9};
        TestCaseUtil.test(110, maxPageForBooks(books, 5), 2);
    }
}
