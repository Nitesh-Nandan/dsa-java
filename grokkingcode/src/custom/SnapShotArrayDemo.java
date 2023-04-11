package custom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SnapshotArray {

    private final int[] arr;
    Map<Integer, int[]> snapMap = new HashMap<>();
    private int version = -1;

    public SnapshotArray(int length) {
        this.arr = new int[length];
    }

    public void setValue(int idx, int state) {
        arr[idx] = state;
    }

    public int snapshot() {
        int[] clone = Arrays.copyOf(arr, arr.length);
        version += 1;
        snapMap.put(version, clone);
        return version;
    }

    public Integer getValue(int idx, int snapshotId1) {
        if (snapshotId1 < version) {
            return snapMap.get(snapshotId1)[idx];
        } else {
            return arr[idx];
        }
    }
}

public class SnapShotArrayDemo {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        SnapshotArray snap = new SnapshotArray(5);
        snap.setValue(2, 10);
        snap.setValue(1, 5);
        snap.snapshot();
        snap.setValue(1, 100);
        snap.setValue(2, 200);

        System.out.println(snap.getValue(1, 0));
        System.out.println(snap.getValue(2, 0));
        System.out.println(snap.getValue(1, 1));
        System.out.println(snap.getValue(2, 1));

    }
}
