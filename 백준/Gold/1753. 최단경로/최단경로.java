import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Node>[] graph;
    static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getValue));

    static int v;
    static int e;
    static int k;

    public static void main(String[] args) throws IOException {
        int[] arr;
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        v = arr[0];
        e = arr[1];
        graph = new List[v + 1];
        for (int i = 0; i < v + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int cur = arr[0];
            int neighbor = arr[1];
            int value = arr[2];
            graph[cur].add(new Node(neighbor, value));
        }
        dijkstra(k);
    }

    public static class Node {
        int cur;
        int value;

        public Node(int cur, int value) {
            this.cur = cur;
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void dijkstra(int start) {
        int[] dist = new int[v + 1];
        Arrays.fill(dist, 1_000_000_000);
        dist[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur = node.cur;
            int curValue = node.value;
            for (Node neighbor : graph[cur]) {
                int distance = curValue + neighbor.getValue();
                if (distance >= dist[neighbor.cur])
                    continue;

                dist[neighbor.cur] = distance;
                pq.add(new Node(neighbor.cur, distance));
            }
        }
        
        for (int i = 1; i <= v; i++) {
            if(dist[i] == 1_000_000_000)
                System.out.println("INF");
            else if(i == k)
                System.out.println(0);
            else
                System.out.println(dist[i]);
        }
    }
}