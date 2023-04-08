package netflix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    public static List<List<String>> groupAnagrams(String[] args) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String str : args) {
            String key = getKey(str);
            if (!groupMap.containsKey(key)) {
                groupMap.put(key, new ArrayList<>());
            }
            groupMap.get(key).add(str);
        }

        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : groupMap.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    static String getKey(String str) {
        int[] arr = new int[26];
        for (char ch : str.toCharArray()) {
            arr[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < 26; i++) {
            sb.append(arr[i]).append("#");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        String[] strList = new String[]{"word", "sword", "drow", "rowd", "iced", "dice"};
        System.out.println(groupAnagrams(strList));
    }
}
