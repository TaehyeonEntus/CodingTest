import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    //depth, 왼발, 오른발
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        int[] ddr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dp = new int[ddr.length][5][5];

        for (int i = 0; i < ddr.length; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = 1_000_000_000;
                }
            }
        }

        dp[0][0][ddr[0]] = 2;
        dp[0][ddr[0]][0] = 2;

        for (int i = 1; i < ddr.length - 1; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    //왼발
                    dp[i][ddr[i]][k] = Math.min(dp[i][ddr[i]][k], dp[i - 1][j][k] + cost(j, ddr[i]));

                    //오른발
                    dp[i][j][ddr[i]] = Math.min(dp[i][j][ddr[i]], dp[i - 1][j][k] + cost(k, ddr[i]));
                }
            }
        }

        int answer = 1_000_000_000;
        for (int j = 0; j < 5; j++)
            for (int k = 0; k < 5; k++)
                answer = Math.min(answer, dp[ddr.length - 2][j][k]);

        System.out.println(answer);
    }

    static int cost(int from, int to) {
        if (from == to) return 1;
        if (from == 0) return 2;
        if ((from == 1 && to == 3) || (from == 3 && to == 1)
                || (from == 2 && to == 4) || (from == 4 && to == 2))
            return 4;
        return 3;
    }
}