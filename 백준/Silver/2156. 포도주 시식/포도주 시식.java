import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    static int[] wine;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        wine = new int[n];

        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = wine[0];
        if(n>1)
            dp[1] = wine[0] + wine[1];
        if(n>2)
            dp[2] = Math.max(wine[0] + wine[2], wine[1] + wine[2]);
        if(n>3)
            dp[3] = Math.max(wine[3] + dp[1], wine[3] + wine[2] + dp[0]);
        for (int i = 4; i < n; i++) {
            dp[i] = Math.max(wine[i] + dp[i - 2], Math.max(wine[i] + wine[i - 1] + dp[i - 3],wine[i] + wine[i - 1] + dp[i - 4]));
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}