import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static List<Edge> list;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = arr[0];
            int m = arr[1];
            int w = arr[2];

            list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int s = arr[0];
                int e = arr[1];
                int d = arr[2];

                list.add(new Edge(s, e, d));
                list.add(new Edge(e, s, d));
            }

            for (int j = 0; j < w; j++) {
                arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int s = arr[0];
                int e = arr[1];
                int d = arr[2];

                list.add(new Edge(s, e, d * -1));
            }

            boolean isCycle = false;
            for (int number = 1; number <= n; number++)
                if (bellman_ford(number)) {
                    isCycle = true;
                    break;
                }

            System.out.println(isCycle ? "YES" : "NO");
        }
    }

    public static boolean bellman_ford(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 1_000_000_000);
        dist[start] = 0;
        
        for (int i = 0; i < n; i++) {
            boolean change = false;
            for (Edge edge : list) {
                int from = edge.start;
                int to = edge.end;
                int distance = edge.cost;

                if (dist[to] > dist[from] + distance) {
                    dist[to] = dist[from] + distance;
                    change = true;
                }
            }
            if(!change)
                break;
        }
        return dist[start] < 0;
    }

    public static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}