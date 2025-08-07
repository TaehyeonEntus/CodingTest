import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    static int[] stair;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        stair = new int[n];

        for (int i = 0; i < n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stair[0];
        if(n>1)
            dp[1] = stair[0] + stair[1];
        if(n>2)
            dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(stair[i] + dp[i - 2], stair[i] + stair[i - 1] + dp[i - 3]);
        }
        System.out.println(dp[n - 1]);
    }
}