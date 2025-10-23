import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int fullBitMap;
    static int[][] dist;
    static int[][] graph;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        fullBitMap = (1 << n) - 1;

        graph = new int[n][n];
        for (int i = 0; i < n; i++)
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dist = new int[n][fullBitMap + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], 1_000_000_000);
        dist[0][1] = 0;

        dfs(0, 1);

        System.out.println(min);
    }

    public static void dfs(int cur, int oldBitMap) {
        if (oldBitMap == fullBitMap)
            if (graph[cur][0] != 0) {
                min = Math.min(min, dist[cur][fullBitMap] + graph[cur][0]);
                return;
            }

        for (int i = 0; i < n; i++)
            if ((1 << i & oldBitMap) == 0 && graph[cur][i] != 0) {
                int newBitMap = (1 << i | oldBitMap);
                if (dist[i][newBitMap] > dist[cur][oldBitMap] + graph[cur][i]) {
                    dist[i][newBitMap] = dist[cur][oldBitMap] + graph[cur][i];
                    dfs(i, newBitMap);
                }
            }
    }
}