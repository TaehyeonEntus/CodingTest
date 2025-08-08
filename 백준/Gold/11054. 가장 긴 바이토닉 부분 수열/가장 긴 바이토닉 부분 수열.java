import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    static int[] dp_asc;
    static int[] dp_desc;
    static int[] numbers;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp_asc = new int[n];
        dp_desc = new int[n];
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp_asc[0] = 1;
        dp_desc[n-1] = 1;
        for (int i = 1; i < n; i++) {
            int maxAsc = 0;
            for (int j = 0; j < i; j++)
                if (numbers[j] < numbers[i])
                    maxAsc = Math.max(maxAsc, dp_asc[j]);

            dp_asc[i] = maxAsc + 1;
        }

        for(int i = n-2; i >= 0; i--) {
            int maxDesc = 0;
            for (int j = n-1; j > i; j--)
                if (numbers[j] < numbers[i])
                    maxDesc = Math.max(maxDesc, dp_desc[j]);

            dp_desc[i] = maxDesc + 1;
        }

        int maxLen = 0;
        for(int i = 0; i<n; i++){
            maxLen = Math.max(maxLen, dp_asc[i] + dp_desc[i]);
            //System.out.println(i + " " + dp_asc[i] + " " + dp_desc[i]);
        }
        System.out.println(maxLen-1);
    }
}