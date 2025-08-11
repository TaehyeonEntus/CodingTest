import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] dp;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0];
        int m = s[1];

        dp = new int[n][n];
        board = new int[n][n];

        for(int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i<n; i++){
            dp[i][0] = board[i][0];
            for(int j = 1; j<n; j++){
                dp[i][j] = dp[i][j-1] + board[i][j];
            }
        }

        for(int i = 0; i<m; i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int x1 = arr[0]-1;
            int y1 = arr[1]-1;

            int x2 = arr[2]-1;
            int y2 = arr[3]-1;

            int answer = 0;
            for(int j = x1; j<=x2; j++){
                if(y1 == 0)
                    answer += dp[j][y2];
                else
                    answer += dp[j][y2] - dp[j][y1-1];
            }
            System.out.println(answer);
        }
    }
}
