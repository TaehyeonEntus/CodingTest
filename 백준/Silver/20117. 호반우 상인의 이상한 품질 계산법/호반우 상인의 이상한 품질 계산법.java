import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int total = 0;

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        if (n % 2 != 0) {
            total += arr[n / 2];
            for (int i = (n / 2) + 1; i < arr.length; i++) {
                total += arr[i] * 2;
            }
        } else {
            for (int i = (n / 2); i < arr.length; i++) {
                total += arr[i] * 2;
            }
        }

        System.out.println(total);
    }
}