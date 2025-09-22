import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[2_000_000 + 1];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int target = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            if (arr[i] > target)
                break;
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] + arr[j]) > target)
                    break;
                dp[arr[i] + arr[j]]++;
            }
        }
        System.out.println(dp[target]);
    }
}