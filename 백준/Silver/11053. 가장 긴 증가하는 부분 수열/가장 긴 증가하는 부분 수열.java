import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    static Map<Integer, Integer> dp;
    static int[] number;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new HashMap<>();

        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp.put(numbers[0], 1);
        for (int i = 1; i < n; i++) {
            int maxLen = 0;
            for (Integer key : dp.keySet())
                if (key < numbers[i])
                    maxLen = Math.max(maxLen, dp.get(key));
            dp.put(numbers[i], maxLen + 1);
        }
        int max = 0;
        for(Integer value : dp.values()){
            max = Math.max(max, value);
        }
        System.out.println(max);
    }
}