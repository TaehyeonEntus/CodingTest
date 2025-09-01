import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Node> queue = new ArrayDeque<>();
    static int n;
    static int m;
    static boolean[] visited;
    static List<Integer>[] graph;
    static Set<Integer>[] set;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];

        graph = new List[n + 1];
        set = new Set[n + 1];

        for (int i = 0; i < n + 1; i++) {
            set[i] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];

            set[a].add(b);
            set[b].add(a);
        }

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>(set[i]);
        }

        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 1; i <= n; i++) {
            queue.clear();
            visited = new boolean[n + 1];
            visited[i] = true;
            queue.add(new Node(i, 0));
            int total = bfs();
            if(total < min) {
                min = total;
                minIndex = i;
            }
        }
        System.out.println(minIndex);
    }

    public static int bfs() {
        int total = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int number = node.number;
            int count = node.count;
            total += count;
            for (int nextNode : graph[number]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(new Node(nextNode, count+1));
                }
            }
        }
        return total;
    }

    public static class Node {
        int number;
        int count;

        public Node(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }
}