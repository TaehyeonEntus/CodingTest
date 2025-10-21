import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] line = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1];

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i <= n; i++)
            line[i] = arr[i - 1];

        //길이 1
        for (int i = 1; i <= n; i++)
            dp[i][i] = 1;

        //길이 2
        for (int i = 1; i < n; i++)
            if (line[i] == line[i + 1])
                dp[i][i + 1] = 1;

        //길이 n
        for (int j = 2; j <= n; j++)
            for (int i = 1; i <= n; i++)
                if (((i+j) <= n) && (line[i] == line[i + j]) && (dp[i + 1][i + j - 1] == 1))
                    dp[i][i+j] = 1;
            

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            int[] range = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int from = range[0];
            int to = range[1];

            sb.append(dp[from][to]).append("\n");
        }

        System.out.println(sb);
    }
}