import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;
    static int count = 0;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int m = arr[1];

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0]-1;
            int b = arr[1]-1;
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 0; i<n; i++){
            if(!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    public static void dfs(int target) {
        if (!visited[target]) {
            visited[target] = true;
            for(int  i : graph[target])
                dfs(i);
        }
    }
}

