import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getCount));
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] dp = new int[100 + 7];
    static boolean[] visited = new boolean[100 + 7];

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int m = arr[1];

        for (int i = 0; i < n + m; i++) {
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map.put(arr[0], arr[1]);
        }

        Arrays.fill(dp, 1_000_000_000);
        dp[1] = 0;
        visited[1] = true;
        queue.add(new Node(1, 0));

        bfs();
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int val = node.val;
            int count = node.count;
            dp[val] = Math.min(dp[val],count);
            if (val > 100)
                continue;

            if (val == 100) {
                //count 오름차순으로 뽑으니까 return해도 최소값 들어옴
                System.out.println(count);
                return;
            }
            if (map.containsKey(val)) {
                visited[val] = true;
                queue.add(new Node(map.get(val), count));
                continue;
            }
            for (int i = 1; i <= 6; i++) {
                if(!visited[val+i]) {
                    visited[val+i] = true;
                    queue.add(new Node(val + i, count + 1));
                }
            }
        }
    }

    public static class Node {
        int val;
        int count;

        public Node(int val, int count) {
            this.val = val;
            this.count = count;
        }

        public int getCount() {
            return count;
        }
    }
}