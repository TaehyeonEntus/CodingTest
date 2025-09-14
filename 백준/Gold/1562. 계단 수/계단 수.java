import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 검색해서 풀었음
 * 비트 마스킹을 이용해서 푸는데 개념이 좀 어려움....
 * 계단수가 아닌 수도 dp로 값을 갱신해줘야 한다는 점이 어려웠음 -> 계산수가 아니여도 결국 값이 0 임, 근데 갱신해야함
 * 0이면 1로, 9면 8로, 둘다 아니면 양쪽으로 넓히면서 DP갱신
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[][][] dp;
    static long mod = 1_000_000_000;
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10][1024];

        //0으로 시작할 수 없음
        for(int k=1;k<=9;k++)
            dp[1][k][1<<k] = 1;

        for(int i=2;i<=n;i++) {
            for(int k=0;k<=9;k++) {
                for(int v = 0; v < (1<<10); v++) {
                    int currV = v | (1<<k);
                    if(k == 0)
                        dp[i][k][currV] += dp[i-1][k+1][v]%mod;
                    else if(k==9)
                        dp[i][k][currV] += dp[i-1][k-1][v]%mod;
                    else
                        dp[i][k][currV] += (dp[i-1][k-1][v]%mod+dp[i-1][k+1][v]%mod);

                    dp[i][k][currV] %= mod;
                }
            }
        }

        for(int i = 0; i<=9; i++){
            answer += dp[n][i][1023];
            answer %= mod;
        }

        System.out.println(answer);
    }
}