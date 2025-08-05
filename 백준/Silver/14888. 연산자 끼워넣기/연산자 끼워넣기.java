import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[] arr;
    static int n;
    static int max = -1_000_000_001;
    static int min = 1_000_000_001;
    static int plus;
    static int minus;
    static int mul;
    static int div;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] calc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        plus = calc[0];
        minus = calc[1];
        mul = calc[2];
        div = calc[3];

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int number) {
        if (depth == n) {
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }

        if (plus != 0) {
            plus--;
            dfs(depth + 1, number + arr[depth]);
            plus++;
        }

        if (minus != 0) {
            minus--;
            dfs(depth + 1, number - arr[depth]);
            minus++;
        }

        if (mul != 0) {
            mul--;
            dfs(depth + 1, number * arr[depth]);
            mul++;
        }

        if (div != 0) {
            div--;
            dfs(depth + 1, number / arr[depth]);
            div++;
        }
    }
}

