import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[100_001];
    static boolean[] visited = new boolean[100_001];
    static Deque<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = arr[0];
        int b = arr[1];
        Arrays.fill(dp, -1);
        dp[a] = 0;
        visited[a] = true;
        queue.add(new Node(a, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int number = node.number;
            int value = node.value;
            if (dp[number] == -1)
                dp[number] = value;
            else
                dp[number] = Math.min(dp[number], value);

            if (number <= 50000 && !visited[2 * number]) {
                visited[2 * number] = true;
                queue.add(new Node(2 * number, value));
            }

            if (number >= 1 && !visited[number - 1]) {
                visited[number - 1] = true;
                queue.add(new Node(number - 1, value + 1));
            }

            if (number < 100000 && !visited[number + 1]) {
                visited[number + 1] = true;
                queue.add(new Node(number + 1, value + 1));
            }

        }

        System.out.println(dp[b]);
    }

    public static class Node {
        int number;
        int value;

        public Node(int number, int value) {
            this.number = number;
            this.value = value;
        }
    }
}