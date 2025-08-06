import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int[][] dp;
    static int[][] colors;
    static int min = 1_000_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n][3];     //최소값 저장 테이블
        colors = new int[n][3]; //색 저장 테이블

        //초기화
        for (int i = 0; i < n; i++) {
            int[] color = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            colors[i] = color;
        }

        //초기화
        dp[0][0] = colors[0][0];
        dp[0][1] = colors[0][1];
        dp[0][2] = colors[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1]+colors[i][0], dp[i-1][2]+colors[i][0]);
            dp[i][1] = Math.min(dp[i-1][0]+colors[i][1], dp[i-1][2]+colors[i][1]);
            dp[i][2] = Math.min(dp[i-1][0]+colors[i][2], dp[i-1][1]+colors[i][2]);
        }
        min = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        System.out.println(min);
    }
}

