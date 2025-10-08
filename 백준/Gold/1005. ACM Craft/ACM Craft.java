import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Node> queue = new ArrayDeque<>();
    static Node[] graph;
    static int[] buildTime;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = arr[0];
            int k = arr[1];

            graph = new Node[n + 1];
            for (int j = 0; j <= n; j++)
                graph[j] = new Node();

            buildTime = new int[n + 1];

            int[] values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < n; j++) {
                graph[j + 1].value = values[j];
            }

            for(int j = 0; j<=n; j++){
                graph[j].number = j;
            }

            for(int j = 0; j<k; j++){
                int[] p_c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int current = p_c[0];
                int child = p_c[1];

                graph[current].children.add(graph[child]);
                graph[child].parents.add(graph[current]);
            }

            for(int j = 1; j<=n; j++)
                if(graph[j].parents.isEmpty()) {
                    queue.add(graph[j]);
                    buildTime[j] = graph[j].value;
                }

            bfs();

            int target = Integer.parseInt(br.readLine());
            System.out.println(buildTime[target]);
        }
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for(Node child : cur.children) {
                buildTime[child.number] = Math.max(buildTime[cur.number] + child.value, buildTime[child.number]);
                child.parents.remove(cur);
                if(child.parents.isEmpty()) {
                    queue.add(child);
                }
            }
        }
    }

    public static class Node {
        int number;
        int value;
        List<Node> parents = new ArrayList<>();
        List<Node> children = new ArrayList<>();

        public Node() {
        }
    }
}
