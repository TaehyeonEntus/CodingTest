import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = intArr[0];
        int k = intArr[1];

        int[] dp = new int[n];
        int[] days = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dp[0] = days[0];

        for(int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + days[i];
        }

        int max = dp[k-1];
        for(int i = 1; i <= n-k; i++){
            max = Math.max(max, dp[i+k-1]-dp[i-1]);
        }
        System.out.println(max);
    }
}