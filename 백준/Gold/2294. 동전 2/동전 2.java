import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> set = new HashSet<>();
    static int[] dp = new int[10_000 + 1];
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        k = arr[1];

        for(int i = 0; i < n; i++)
            set.add(Integer.parseInt(br.readLine()));

        Arrays.fill(dp, 1_000_000_000);
        dp[0] = 0;
        for(int i = 1; i <= 10_000; i++)
            for(int number : set)
                if(i-number >= 0)
                    dp[i] = Math.min(dp[i], dp[i-number] + 1);

        System.out.println(dp[k] == 1_000_000_000 ? -1 : dp[k]);
    }
}
