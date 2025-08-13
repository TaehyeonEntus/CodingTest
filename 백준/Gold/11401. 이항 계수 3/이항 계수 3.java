import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int p = 1000000007;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = intArr[0];
        k = intArr[1];

        dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = i * dp[i - 1] % p;
        }

        long a = dp[n];

        long b = (dp[k] * dp[n - k]) % p;

        System.out.println(a * modulation(b,p-2) % p);
    }

    public static long modulation(long base, long exp) {
        if (exp == 1)
            return base % p;

        long nextTimes = modulation(base,exp / 2);

        if (exp % 2 == 0) {    //계수가 짝수일 때
            return nextTimes * nextTimes % p;
        } else        //계수가 홀수일 때
            return (nextTimes * nextTimes % p) * (base % p) % p;
    }
}
