import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] answer;
    static List<List<Integer>> graph;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line;
        line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = line[0];
        int m = line[1];
        int startPoint = line[2] - 1;
        visited = new boolean[n];
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        answer = new int[n];

        for (int i = 0; i < m; i++) {
            line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = line[0] - 1;
            int b = line[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n; i++)
            graph.get(i).sort(Collections.reverseOrder());

        dfs(startPoint);

        for (int i : answer)
            System.out.println(i);
    }

    public static void dfs(int a) {
        visited[a] = true;
        answer[a] = count++;
        for (int i : graph.get(a)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}

