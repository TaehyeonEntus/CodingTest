import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        int[] password = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int n = password.length;
        dp = new int[n];
        dp[0] = 1;

        if (password[0] == 0) {
            System.out.println(0);
            return;
        }

        if (n == 1) {
            System.out.println(1);
            return;
        }

        if (password[1] == 0 && password[0] > 2) {
            System.out.println(0);
            return;
        }

        if ((password[0] < 2 || password[0] == 2 && password[1] <= 6) && password[1] != 0)
            dp[1] = 2;
        else
            dp[1] = 1;

        for (int i = 2; i < n; i++) {
            int before = password[i - 1];
            int current = password[i];

            if (before == 0 && current == 0) {
                System.out.println(0);
                return;
            }
            if (current != 0)
                dp[i] += dp[i - 1]%1_000_000;
            if ((before > 2) || (before == 2 && current > 6) || before == 0)
                continue;
            dp[i] += dp[i - 2]%1_000_000;
        }

        System.out.println(dp[n - 1]%1_000_000);
    }
}