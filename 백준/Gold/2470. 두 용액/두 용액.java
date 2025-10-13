import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int gap = Integer.MAX_VALUE;

        int numA = Integer.MAX_VALUE;
        int numB = Integer.MAX_VALUE;

        if (arr.length == 2) {
            System.out.println(Math.min(arr[0], arr[1]) + " " + Math.max(arr[0], arr[1]));
            return;
        }
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            if ((i + 1) > (n - 1))
                break;
            int index = Arrays.binarySearch(arr, i + 1, n - 1, a * -1);
            if (index >= 0) {
                System.out.println(Math.min(a, arr[index]) + " " + Math.max(a, arr[index]));
                return;
            } else {
                int left = (index + 2) * -1;
                int right = (index + 1) * -1;

                if (left >= i+1 && gap > Math.abs(a + arr[left])) {
                    gap = Math.abs(a + arr[left]);
                    numA = a;
                    numB = arr[left];
                }

                if (right < n && gap > Math.abs(a + arr[right])) {
                    gap = Math.abs(a + arr[right]);
                    numA = a;
                    numB = arr[right];
                }
            }

        }
        System.out.println(Math.min(numA, numB) + " " + Math.max(numB, numA));
    }
}
