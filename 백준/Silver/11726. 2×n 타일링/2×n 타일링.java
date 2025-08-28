import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;
    static int mod = 10_007;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[0] = 0;
        if (n > 0)
            dp[1] = 1;
        if (n > 1)
            dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] % mod + dp[i - 2] % mod) % mod;
        }
        System.out.println(dp[n]);
    }
}

