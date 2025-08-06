import java.io.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        dp = new int[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = -1;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            count++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n] + " " + count);
    }
}

