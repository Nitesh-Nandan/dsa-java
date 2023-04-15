package javads;

import java.util.TreeMap;

public class JavaTreeMapDemo {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(2, 5);
        treeMap.put(4, 10);
        treeMap.put(5, 15);
        treeMap.put(6, 10);
        treeMap.put(15, 100);

//      key doesn't exists
        System.out.println(treeMap.floorEntry(7));
        System.out.println(treeMap.ceilingEntry(7));

//      key exists
        System.out.println(treeMap.floorEntry(6));
        System.out.println(treeMap.ceilingEntry(6));

//        some other
        System.out.println(treeMap.lastEntry());
        System.out.println(treeMap.firstEntry());
    }
}
