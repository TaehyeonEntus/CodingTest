import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long[] dp_sum;
    static int[] dp_mod;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0];
        int m = s[1];
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dp_sum = new long[n];
        dp_mod = new int[n];

        dp_sum[0] = numbers[0];
        for(int i = 1; i<n; i++){
            dp_sum[i] = dp_sum[i-1] + numbers[i];
        }

        long count = 0;

        dp_mod[0] = numbers[0]%m;
        for(int i = 1; i < n; i++){
            dp_mod[i] = (int)(dp_sum[i] % m);
        }

        int[] mod_count = new int[m];

        for(int i = 0; i < n; i++){
            mod_count[dp_mod[i]]++;
        }

        //누적 합 자체가 m으로 나누어 떨어지는 경우, 0부터 현재 까지의 합
        count+=mod_count[0];

        //범위의 값이 m으로 나누어 떨어지는 경우 a부터 b까지의 값
        for (int i = 0; i < m; i++) {
            if (mod_count[i] >= 2) {
                count += ((long) mod_count[i] * (mod_count[i] - 1)) / 2;
            }
        }

        System.out.println(count);
    }
}
