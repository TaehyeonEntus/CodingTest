import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static List<Integer>[] graph;
    static Deque<Integer> queue = new ArrayDeque<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < arr.length; j++)
                if (arr[j] == 1)
                    graph[i].add(j);
        }

        for (int i = 0; i < n; i++) {

            for (int j : bfs(i))
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static int[] bfs(int start) {
        visited = new boolean[n];

        for (Integer integer : graph[start]) {
            visited[integer] = true;
            queue.add(integer);
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer integer : graph[poll]) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    queue.add(integer);
                }
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = visited[i] ? 1 : 0;
        }
        return res;
    }
}