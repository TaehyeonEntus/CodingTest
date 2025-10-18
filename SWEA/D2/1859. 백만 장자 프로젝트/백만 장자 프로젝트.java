import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            stack.clear();
            int n = Integer.parseInt(br.readLine());
            int[] prices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            long total = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (stack.isEmpty())
                    stack.push(prices[i]);
                else if (prices[i] > stack.peek()) {
                    stack.pop();
                    stack.push(prices[i]);
                } else if (prices[i] < stack.peek()) {
                    total += stack.peek() - prices[i];
                }
            }
            System.out.println("#" + t + " " + total);
        }
    }
}