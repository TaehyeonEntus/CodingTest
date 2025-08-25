import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> graph;
    static Deque<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = line[0] - 1;
            int b = line[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n; i++)
            graph.get(i).sort(Comparator.reverseOrder());

        queue.add(0);
        bfs();

        int count = 0;
        for (boolean b : visited)
            if (b)
                count++;

        System.out.println(count-1);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int num = queue.poll();
            visited[num] = true;
            for (int i : graph.get(num)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}

