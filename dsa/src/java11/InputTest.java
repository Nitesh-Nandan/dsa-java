package java11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class InputTest {

    static void input2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int str: arr) {
            System.out.println(str);
        }

        String line = reader.readLine().trim();
        System.out.println(line.charAt(0));
        System.out.println(line.charAt(2));
        String str = reader.readLine();
        System.out.println(str);
    }

    public static void main(String[] args) throws IOException {
        input2();
    }

    static void input1() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string");
        String str = sc.nextLine();

        System.out.println("Enter a number");
        int val = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter a string");
        String str2 = sc.nextLine();

        System.out.println("Enter a number");
        int val2 = sc.nextInt();


        System.out.println(val);
        System.out.println(str);
        System.out.println(val2);
        System.out.println(str2);
    }
}
