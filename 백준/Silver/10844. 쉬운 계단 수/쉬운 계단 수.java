import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp; //자리수 , 끝 자리수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][10];
        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        for(int i = 2; i < n+1; i++) {
            for(int j = 0; j < 10; j++) {
                int temp = dp[i - 1][j];
                if(j == 0) {
                    dp[i][1] = (dp[i][1] + temp)%1_000_000_000;
                } else if(j == 9) {
                    dp[i][8] = (dp[i][8] + temp)%1_000_000_000;
                } else{
                    dp[i][j+1] = (dp[i][j+1] + temp)%1_000_000_000;
                    dp[i][j-1] = (dp[i][j-1] + temp)%1_000_000_000;
                }
            }
        }

        int total = 0;
        for(int i = 0; i < 10; i++) {
            total += dp[n][i];
            total %= 1_000_000_000;
        }
        System.out.println(total);
    }
}