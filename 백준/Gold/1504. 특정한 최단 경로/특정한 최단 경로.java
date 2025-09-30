import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getValue));
    static List<Node>[] graph;
    static int n;
    static int e;
    static int o1;
    static int o2;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        e = arr[1];

        graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];

            //왕
            graph[a].add(new Node(b, c));
            //복
            graph[b].add(new Node(a, c));
        }

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        o1 = arr[0];
        o2 = arr[1];

        int[] a = dijkstra(1);
        int bridge = dijkstra(o1,o2);
        int[] b = dijkstra(n);

        int answer1 = 0;
        int answer2 = 0;

        if(a[o1] != 1_000_000_000 && bridge != 1_000_000_000 && b[o2] != 1_000_000_000)
            answer1 = a[o1]+bridge+b[o2];

        if(a[o2] != 1_000_000_000 && bridge != 1_000_000_000 && b[o1] != 1_000_000_000)
            answer2 = a[o2]+bridge+b[o1];

        int answer = Math.min(answer1,answer2);
        if(answer == 0)
            answer = -1;

        System.out.println(answer);
    }

    public static class Node {
        int number;
        int value;

        public Node(int number, int value) {
            this.number = number;
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 1_000_000_000);
        dist[start] = 0;

        boolean[] visited = new boolean[n + 1];
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int p_number = node.number;
            int p_cost = node.value;

            if (visited[p_number])
                continue;
            visited[p_number] = true;

            for (Node child : graph[p_number]) {
                int c_number = child.number;
                int c_cost = child.value;
                if (dist[c_number] > p_cost + c_cost) {
                    dist[c_number] = p_cost + c_cost;
                    pq.add(new Node(c_number, dist[c_number]));
                }
            }
        }
        return dist;
    }
    public static int dijkstra(int start, int end) {
        int[] dist = dijkstra(start);
        return dist[end];
    }
}