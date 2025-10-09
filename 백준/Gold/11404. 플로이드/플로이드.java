import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Node>[] graph;
    static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getCost));
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        graph = new List[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            int cost = arr[2];

            graph[a].add(new Node(b, cost));
        }

        for (int j = 1; j <= n; j++) {
            int[] dijkstra = dijkstra(j);
            for (int l = 1; l <= n; l++) {
                System.out.print((dijkstra[l]==1_000_000_000?0:dijkstra[l]) + " ");
            }
            System.out.println();
        }
    }

    public static int[] dijkstra(int start) {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];

        Arrays.fill(dist, 1_000_000_000);
        dist[start] = 0;
        visited[start] = true;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node next : graph[cur.number]) {
                if (visited[next.number])
                    continue;
                if (dist[next.number] > (dist[cur.number] + next.cost)) {
                    dist[next.number] = (dist[cur.number] + next.cost);
                    pq.add(new Node(next.number, dist[next.number]));
                }
            }
        }
        return dist;
    }

    public static class Node {
        int number;
        int cost;

        public Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }
    }
}