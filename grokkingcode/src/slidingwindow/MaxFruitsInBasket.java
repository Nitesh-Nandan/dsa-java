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
        int ans = 0;
        int si = 0;
        Map<Character, Integer> fruitMap = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            fruitMap.put(fruits[i], fruitMap.getOrDefault(fruits[i], 0) + 1);

            while (fruitMap.size() > basket) {
                char prevFruit = fruits[si];
                fruitMap.put(prevFruit, fruitMap.get(prevFruit) - 1);
                if (fruitMap.get(prevFruit) == 0) {
                    fruitMap.remove(prevFruit);
                }
                si++;
            }
            ans = Math.max(ans, i - si + 1);
        }
        return ans;
    }
}
