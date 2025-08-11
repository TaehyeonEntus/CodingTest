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
        char[] str = br.readLine().toCharArray();
        dp = new int[str.length+1];
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            char targetChar = s[0].charAt(0);
            int start = Integer.parseInt(s[1]);
            int end = Integer.parseInt(s[2]);
            dp[0] = 0;

            if (targetChar == str[0])
                dp[1] = 1;
            else
                dp[1] = 0;

            for (int j = 2; j < str.length+1; j++) {
                if (targetChar == str[j-1])
                    dp[j] = dp[j - 1] + 1;
                else
                    dp[j] = dp[j - 1];
            }

            System.out.println(dp[end+1]-dp[start]);
        }
    }
}