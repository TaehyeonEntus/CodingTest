import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static int[] histogram;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals("0"))
                return;

            int[] s = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = s[0];
            histogram = new int[n + 1];
            if (n >= 0) System.arraycopy(s, 1, histogram, 0, n);

            System.out.println(solve(n));
        }
    }

    public static long solve(int n) {
        stack.clear();
        long length = histogram.length;

        long maxArea = 0;

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
                long height = histogram[stack.pop()];
                long width = stack.isEmpty() ? i : i - stack.peek() - 1;
                if (maxArea < height * width)
                    maxArea = height * width;
            }
            stack.push(i);
        }

        return maxArea;
    }
}
