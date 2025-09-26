import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long a = arr[0];
        long b = arr[1];

        long c = a * b;
        for (int i = (int) Math.sqrt(c); i >= 1; i--)
            if (c % i == 0)
                if (gcd(i, c / i) == a) {
                    System.out.println(i + " " + c / i);
                    break;
                }

    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}