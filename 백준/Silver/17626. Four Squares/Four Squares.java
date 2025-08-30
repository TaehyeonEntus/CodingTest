import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int max;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        max = (int) Math.sqrt(n);
        dp = new int[n + 1];
        Arrays.fill(dp, 4);
        dp[0] = 0;
        for (int i = 1; i <= max; i++) {
            dp[i * i] = 1;
        }
        for (int i = 1; i <= max; i++) {
            int pow = i*i;
            for(int j = n; j >= pow; j--) {
                dp[j] = Math.min(dp[j], dp[j-pow]+1);
            }
        }
        for (int i = 1; i <= max; i++) {
            int pow = i*i;
            for(int j = n; j >= pow; j--) {
                dp[j] = Math.min(dp[j], dp[j-pow]+1);
            }
        }
        for (int i = 1; i <= max; i++) {
            int pow = i*i;
            for(int j = n; j >= pow; j--) {
                dp[j] = Math.min(dp[j], dp[j-pow]+1);
            }
        }
        System.out.println(dp[n]);
    }
}