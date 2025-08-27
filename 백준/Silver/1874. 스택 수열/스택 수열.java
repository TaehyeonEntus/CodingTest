import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> queue = new ArrayDeque<>();
    static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            queue.add(Integer.parseInt(br.readLine()));

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+").append("\n");
            while (!queue.isEmpty() && !stack.isEmpty() && (queue.peekFirst().equals(stack.peek()))) {
                queue.pollFirst();
                stack.pop();
                sb.append("-").append("\n");
            }
        }

        if(!queue.isEmpty() && !stack.isEmpty()) {
            sb.setLength(0);
            sb.append("NO");
        }

        System.out.println(sb);
    }
}

