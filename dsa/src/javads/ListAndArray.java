package javads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ListAndArray {

    public static void main(String[] args) {
        run();
//        listToArray();
//        arrayToList();
//        playingWithDoubleList();
    }

    static void playWithList() {
        List<Integer> list = new LinkedList<>();
        list.add(0, 10);
//        list.add(5, 20);

        list.forEach(System.out::println);
    }

    static void listToArray() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();

        List<String> strList = new ArrayList<>();
        strList.add("Nitesh");
        strList.add("Nandan");

        String[] strArr = strList.toArray(new String[0]);

        for (String str : strArr) {
            System.out.print(str);
        }
    }

    static void arrayToList() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list);

        String[] strArr = new String[]{"Hello", "Nitesh", "Nandan"};
        List<String> strList = Arrays.stream(strArr).collect(Collectors.toList());
        List<String> stringList2 = Arrays.asList(strArr);
        System.out.println(strList);
        System.out.println(stringList2);

        double[] doubles = new double[]{1, 2, 3, 4, 5};
        List<Double> doublesList = Arrays.stream(doubles).boxed().collect(Collectors.toList());
        System.out.println(doublesList);


        SampleObject[] sampleObjects = new SampleObject[]{new SampleObject(), new SampleObject()};
        List<SampleObject> sampleObjectList = Arrays.asList(sampleObjects);
        System.out.println(sampleObjectList);
    }

    static void playingWithDoubleList() {
        List<List<Integer>> list = new ArrayList<>(5);
        list.add(new ArrayList<>());list.add(new ArrayList<>());list.add(new ArrayList<>());list.add(new ArrayList<>());
        list.get(0).add(0);
        list.get(1).add(0);list.get(1).add(2);
        list.get(2).add(0);list.get(2).add(1);list.get(2).add(2);
        list.get(3).add(0);list.get(3).add(1);list.get(3).add(2);list.get(3).add(3);

        for(int i=0; i<list.size(); i++) {
            for(int j=0; j<list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.println();

    }

    static void run() {
        float len = 7.0f;
        float width = 6.0f;

        for(int i=0; i<10; i++) {
            float nlen = len + (0.5f * i);
            for(int j=0; j<10; j++) {
                float nwidth  = width + (0.5f*j);

                int dim  = (int) Math.ceil((nlen * nwidth * 12 * 12 * 9));
                if(dim % 8 == 2) {
                    System.out.println("len: " + nlen + ", width: " + nwidth);
                }
            }
        }
    }
}
