import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] str = br.readLine().toCharArray();
        int strLength = str.length;

        dp = new int[26][strLength];


        dp[str[0] - 'a'][0] = 1;

        for (int i = 1; i < strLength; i++) {
            for (int c = 0; c < 26; c++) {
                dp[c][i] = dp[c][i - 1];
            }
            dp[str[i] - 'a'][i]++;
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            char targetChar = s[0].charAt(0);
            int start = Integer.parseInt(s[1]);
            int end = Integer.parseInt(s[2]);

            int idx = targetChar - 'a';
            int answer = dp[idx][end];
            if (start > 0) {
                answer -= dp[idx][start - 1];
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
