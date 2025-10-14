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
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        graph = new List[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int root = arr[0];
            for (int j = 1; j < arr.length - 1; j += 2)
                graph[root].add(new Node(arr[j], arr[j + 1]));
        }

        int max = 0;

        Pair pair1 = dijkstra(1);

        Pair pair2 = dijkstra(pair1.index);

        System.out.println(pair2.value);
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

    public static Pair dijkstra(int start){
        int[] dist = new int[n+1];
        Arrays.fill(dist, 1_000_000_000);
        dist[start] = 0;

        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(!visited[cur.number])
                visited[cur.number] = true;
            for(Node node : graph[cur.number]){
                int cost = dist[cur.number] + node.cost;
                if(dist[node.number] > cost){
                    dist[node.number] = cost;
                    pq.add(new Node(node.number, cost));
                }
            }
        }

        Pair maxPair = new Pair(-1, -1);
        for(int i = 0; i<dist.length; i++){
            if(dist[i] == 1_000_000_000)
                dist[i] = -1;
            if(dist[i] > maxPair.value){
                maxPair.index = i;
                maxPair.value = dist[i];
            }
        }
        return maxPair;
    }

    public static class Pair{
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
