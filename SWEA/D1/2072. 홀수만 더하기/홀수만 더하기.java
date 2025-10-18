import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int oddSum = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .filter(i->i%2!=0)
                    .sum();
            System.out.println("#"+t+" "+oddSum);
        }
    }
}