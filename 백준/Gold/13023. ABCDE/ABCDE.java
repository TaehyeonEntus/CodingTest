import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];

        graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 0; i<n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(0, i);
        }

        System.out.println(answer);
    }

    public static void dfs(int depth, int number) {
        if (answer == 1)
            return;

        if (depth >= 4) {
            answer = 1;
            return;
        }

        for (int friend : graph[number]) {
            if(!visited[friend]){
                visited[friend] = true;
                dfs(depth + 1, friend);
                visited[friend] = false;
            }
        }
    }
}