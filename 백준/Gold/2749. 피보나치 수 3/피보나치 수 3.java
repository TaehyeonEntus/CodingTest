import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static long mod = 1_000_000;
    static long PISANO = 1_500_000;
    static long[] dp = new long[1_500_001];

    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= 1_500_000; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;

        System.out.println(dp[(int) (n%PISANO)]);
    }
}