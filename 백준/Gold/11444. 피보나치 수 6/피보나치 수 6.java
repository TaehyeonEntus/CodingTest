import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long n;
    static int mod = 1_000_000_007;
    static Map<Long, Long> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());

        System.out.println(fibo(n));
    }

    //Fast Doubling 피보나치 공식 사용.... 검색해서...
    public static long fibo(long n) {
        if (n == 1 || n == 2) return 1;
        if (dp.containsKey(n)) return dp.get(n);
        long nextTimes = n / 2;
        if (n % 2 == 0) {
            long fk = fibo(nextTimes);
            long fk_1 = fibo(nextTimes - 1);
            long answer = (fk * ((2 * fk_1 + fk) % mod)) % mod;
            dp.put(n, answer);
            return answer;
        } else {
            long fk = fibo(nextTimes);
            long fk1 = fibo(nextTimes + 1);
            long answer = (fk * fk + fk1 * fk1) % mod;
            dp.put(n, answer);
            return answer;
        }
    }
}
