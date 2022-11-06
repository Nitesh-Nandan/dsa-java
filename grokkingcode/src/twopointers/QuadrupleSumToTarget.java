package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {
    public static void main(String[] args) {
        System.out.println(findQuadruple(new int[]{4, 1, 2, -1, 1, -3}, 1)); // [[-3, -1, 1, 4], [-3, 1, 1, 2]]
        System.out.println(findQuadruple(new int[]{2, 0, -1, 1, -2, 2}, 2)); // [[-2, 0, 2, 2], [-1, 0, 1, 2]]
    }

    static List<List<Integer>> findQuadruple(int[] arr, int tar) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<arr.length-4; i++) {
            if(i>0 && arr[i] == arr[i-1]) {
                continue;
            }
            for(int j=i+1; j<arr.length -3; j++) {
                if(arr[j] == arr[j-1]) {
                    continue;
                }
                int left = j+1;
                int right = arr.length - 1;

                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if(sum == tar) {
                        ans.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left++;
                        right--;
                        while (left < right && arr[left] == arr[left - 1])
                            left++; // skip same element to avoid duplicate quadruplets
                        while (left < right && arr[right] == arr[right + 1])
                            right--; // skip same
                    }
                    else if(sum < tar) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
