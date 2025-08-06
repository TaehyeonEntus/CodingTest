import java.io.*;
import java.util.Arrays;

public class Main {
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[21][21][21];
        dp[0][0][0] = 1;
        for (int a = 0; a <= 20; a++) {
            for (int b = 0; b <= 20; b++) {
                for (int c = 0; c <= 20; c++) {
                    if (a == 0 || b == 0 || c == 0)
                        dp[a][b][c] = 1;
                    else if (a < b && b < c)
                        dp[a][b][c] = dp[a][b][c - 1] + dp[a][b - 1][c - 1] - dp[a][b - 1][c];
                    else
                        dp[a][b][c] = dp[a - 1][b][c] + dp[a - 1][b - 1][c] + dp[a - 1][b][c - 1] - dp[a - 1][b - 1][c - 1];

                }
            }
        }
        while (true) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            if (a == -1 && b == -1 && c == -1)
                break;

            System.out.print("w(" + a + ", " + b + ", " + c + ") = ");
            if (a <= 0 || b <= 0 || c <= 0)
                System.out.println(dp[0][0][0]);
            else if (a > 20 || b > 20 || c > 20)
                System.out.println(dp[20][20][20]);
            else
                System.out.println(dp[a][b][c]);
        }
    }
}

