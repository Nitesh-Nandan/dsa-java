package fastslowpointer;

public class CircularArray {

    public static void main(String[] args) {
        System.out.println(hasCircularArray(new int[]{2,-1,1,2,2})); // true
        System.out.println(hasCircularArray(new int[]{-1,-2,-3,-4,-5,6})); // false
        System.out.println(hasCircularArray(new int[]{1,-1,5,1,4})); // true
    }

    static boolean hasCircularArray(int[] arr) {
        int[] color = new int[arr.length];
        for(int i=0; i<arr.length;i++) {
            if(color[i]==0 && doDfs(arr, color, i)) {
                return true;
            }
        }
        return false;
    }

    static boolean doDfs(int[] arr, int[] color, int start) {
        if(color[start] == 2) {
            return false;
        }
        color[start] = 1;

        int next = (start + arr[start]) % arr.length;
        next = (next + arr.length) % arr.length;

        if(start == next || arr[start] * arr[next] < 0) {
            color[start] = 2;
            return false;
        }

        if(color[next] == 1) {
            color[start] = 2;
            return true;
        }

        if(doDfs(arr, color, next)) {
            return true;
        }
        color[start] = 2;
        return false;
    }
}
