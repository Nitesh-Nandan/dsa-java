package custom;

import java.util.HashMap;
import java.util.Map;

class TimeStamp {
    Map<Integer, Map<String, String>> mp = new HashMap<>();

    public TimeStamp() {
        // Write your code here
    }

    // Set TimeMap data variables
    public boolean setValue(String key, String value, int timestamp) {
        mp.putIfAbsent(timestamp, new HashMap<>());
        mp.get(timestamp).put(key, value);
        return true;
    }

    // Get the value for the given key and timestamp
    public String getValue(String key, int timeStamp) {
        while (timeStamp >= 0) {
            if (mp.containsKey(timeStamp)) {
                return mp.get(timeStamp).get(key);
            }
            timeStamp--;
        }
        return "";
    }
}

public class TimeBasedKeyValuePair {
}
