import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Node> list = new ArrayList<>();

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];

        for (int i = 0; i < m; i++) {
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(new Node(arr[0],arr[1],arr[2]));
        }

        long[] dist = bellmanFord(1);

        if (dist[0] == -1)
            System.out.println(-1);
        else
            for (int i = 2; i < dist.length; i++)
                System.out.println(dist[i] == 1_000_000_000 ? -1 : dist[i]);
    }

    public static long[] bellmanFord(int start) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, 1_000_000_000);
        dist[start] = 0;

        //간선의 갯수만큼 전체 탐색을 반복
        for (int i = 1; i <= n; i++)
            for (Node node : list)
                if (dist[node.cur] != 1_000_000_000 && dist[node.next] > dist[node.cur] + node.cost) {
                    dist[node.next] = dist[node.cur] + node.cost;

                    //사이클이 끝날 때도 갱신을 계속 하고있으면 무한사이클로 간주
                    if(i == n)
                        dist[0] = -1;
                }


        return dist;
    }

    public static class Node {
        int cur;
        int next;
        int cost;

        public Node(int cur, int next, int cost) {
            this.cur = cur;
            this.next = next;
            this.cost = cost;
        }
    }
}
