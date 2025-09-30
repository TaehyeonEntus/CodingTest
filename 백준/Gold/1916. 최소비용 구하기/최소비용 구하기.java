import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static List<Bus>[] cities;
    static PriorityQueue<Bus> pq = new PriorityQueue<>(Comparator.comparingInt(Bus::getValue));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        cities = new List[n + 1];
        for (int i = 0; i <= n; i++)
            cities[i] = new ArrayList<>();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = arr[0];
            int end = arr[1];
            int cost = arr[2];

            cities[start].add(new Bus(end, cost));
        }

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = arr[0];
        int end = arr[1];

        dijkstra(start, end);
    }

    public static class Bus {
        int number;
        int value;

        public Bus(int number, int value) {
            this.number = number;
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void dijkstra(int start, int end) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, 1_000_000_000);
        dist[start] = 0;
        pq.add(new Bus(start, 0));

        while (!pq.isEmpty()) {
            Bus parent = pq.poll();
            int parentNumber = parent.number;
            int parentValue = parent.value;

            if (visited[parentNumber])
                continue;
            else
                visited[parentNumber] = true;

            for (Bus child : cities[parentNumber]) {
                int childNumber = child.number;
                int childValue = child.value;
                if (dist[childNumber] > parentValue + childValue) {
                    dist[childNumber] = parentValue + childValue;
                    pq.add(new Bus(childNumber, dist[childNumber]));
                }
            }
        }
        System.out.println(dist[end]);
    }
}