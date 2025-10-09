import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] colors;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        colors = new int[n][3];
        for (int i = 0; i < n; i++)
            colors[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //층 시작색 현재색
        int[][][] dp = new int[n][3][3];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < 3; j++)
                for(int k = 0; k < 3; k++)
                    dp[i][j][k] = 1_000_000_000;
        for (int i = 0; i < 3; i++)
            dp[0][i][i] = colors[0][i];

        for (int i = 1; i < n; i++) {
            dp[i][0][0] = Math.min(dp[i - 1][0][1], dp[i - 1][0][2]) + colors[i][0];
            dp[i][0][1] = Math.min(dp[i - 1][0][0], dp[i - 1][0][2]) + colors[i][1];
            dp[i][0][2] = Math.min(dp[i - 1][0][0], dp[i - 1][0][1]) + colors[i][2];

            dp[i][1][0] = Math.min(dp[i - 1][1][1], dp[i - 1][1][2]) + colors[i][0];
            dp[i][1][1] = Math.min(dp[i - 1][1][0], dp[i - 1][1][2]) + colors[i][1];
            dp[i][1][2] = Math.min(dp[i - 1][1][0], dp[i - 1][1][1]) + colors[i][2];

            dp[i][2][0] = Math.min(dp[i - 1][2][1], dp[i - 1][2][2]) + colors[i][0];
            dp[i][2][1] = Math.min(dp[i - 1][2][0], dp[i - 1][2][2]) + colors[i][1];
            dp[i][2][2] = Math.min(dp[i - 1][2][0], dp[i - 1][2][1]) + colors[i][2];
        }

        int rCost = Math.min(dp[n - 1][0][1], dp[n - 1][0][2]);
        int gCost = Math.min(dp[n - 1][1][0], dp[n - 1][1][2]);
        int bCost = Math.min(dp[n - 1][2][0], dp[n - 1][2][1]);

        System.out.println(Math.min(rCost, Math.min(gCost, bCost)));
    }
}