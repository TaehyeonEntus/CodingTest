import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.*;

public class Main {
    static int[][] dp;
    static int[][] triangle;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        triangle = new int[n][n];
        for(int i = 0; i<n; i++) {
            triangle[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i<n; i++) {
            int maxRight = triangle[i].length - 1;
            for(int j = 0; j< triangle[i].length; j++) {
                if(j==0)
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                else if(j==maxRight)
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                else {
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
                }
            }
        }
        int max = 0;
        for(int i = 0; i<n; i++) {
            max = Math.max(max, dp[n-1][i]);
       }
        System.out.println(max);
    }
}