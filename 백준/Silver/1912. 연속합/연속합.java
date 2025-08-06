import java.io.*;
import java.util.Arrays;

public class Main {
    static long[] dp;
    static int max = -1001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] dp = new int[n];
        dp[0] = numbers[0];
        max = numbers[0];
        for (int i = 1; i < n; i++) {
            dp[i]= Math.max(dp[i-1] + numbers[i], numbers[i]);
            max = Math.max(dp[i],max);
        }
        System.out.println(max);
    }
}

