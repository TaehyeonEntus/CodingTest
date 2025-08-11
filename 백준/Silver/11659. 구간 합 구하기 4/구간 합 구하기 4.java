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
        int m = intArr[1];
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = numbers[0];
        for(int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1] + numbers[i-1];
        }

        for(int i = 0; i<m; i++) {
            int[] range = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(dp[range[1]]-dp[range[0]-1]);
        }
    }
}