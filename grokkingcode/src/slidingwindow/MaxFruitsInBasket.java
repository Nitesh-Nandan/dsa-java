package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitsInBasket {
    public static void main(String[] args) {
        char[] fruits1 = {'A', 'B', 'C', 'A', 'C'}; //3
        System.out.println(maxFruit(fruits1, 2));

        char[] fruits2 = {'A', 'B', 'C', 'B', 'B', 'C'}; //5
        System.out.println(maxFruit(fruits2, 2));
    }

    static int maxFruit(char[] fruits, int basket) {
       return -1;
    }
}
