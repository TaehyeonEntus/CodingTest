import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long a, b;
    static long total;
    static long count_a;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            count_a = 0;

            long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            a = arr[0];
            b = arr[1];

            total = a + b;

            dfs(1,0);

            System.out.println("Case #"+(i+1)+": "+(double) count_a/combination(total,a));
        }
    }

    public static void dfs(int A, int B) {
        if (A <= B)
            return;

        if ((A + B) == total) {
            count_a++;
            return;
        }

        if (A != a)
            dfs(A + 1, B);

        if (B != b)
            dfs(A, B + 1);
    }

    public static long combination(long n, long r) {
        if (r < 0 || r > n) return 0;
        r = Math.min(r, n - r);  // nCr = nC(n-r)
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i) / (i + 1);
        }
        return res;
    }

}