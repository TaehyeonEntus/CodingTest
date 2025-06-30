import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        int[][] item = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] strArr = sc.nextLine().split(" ");
            item[i][0] = Integer.parseInt(strArr[0]);
            item[i][1] = Integer.parseInt(strArr[1]);
        }

        int[][] dp = new int[N+1][K+1];

        for (int k = 1; k <= K; k++) {
            for (int i = 1; i <= N; i++) {
                if (k < item[i-1][0]) {
                    dp[i][k] = dp[i-1][k];
                } else {
                    dp[i][k] = Math.max(dp[i - 1][k],
                                    //현재 아이템의 밸류      //남는 칸에 들어갈 밸류
                                    item[i-1][1]        +   dp[i-1][k - item[i-1][0]]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}