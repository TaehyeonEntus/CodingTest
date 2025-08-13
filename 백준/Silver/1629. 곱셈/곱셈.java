import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int number;
    static int times;
    static int mod;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        number = intArr[0];
        times = intArr[1];
        mod = intArr[2];

        System.out.println(solve(times));
    }

    public static long solve(int times) {
        if (times == 1)
            return number%mod;
        int nextTimes = times/2;
        long solve = solve(nextTimes);
        if (times % 2 == 0)
            return ((solve%mod) * (solve%mod)) % mod;
        else
            return (((number%mod) * solve%mod) * (solve%mod)) % mod;
    }
}
