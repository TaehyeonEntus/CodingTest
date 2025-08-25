import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static BufferedReader br;
    static int[][] cabbage;
    static int n;
    static int m;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());
        for (int i = 0; i < times; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = arr[0];
            m = arr[1];
            int k = arr[2];

            visited = new boolean[n][m];
            cabbage = new int[n][m];
            list = new ArrayList<>();

            for (int t = 0; t < k; t++) {
                int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                cabbage[xy[0]][xy[1]] = 1;
            }

            for (int a = 0; a < n; a++)
                for (int b = 0; b < m; b++)
                    if (!visited[a][b] && cabbage[a][b] == 1)
                        list.add(bfs(a, b));

            System.out.println(list.size());
        }
    }

    public static int bfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;

        if (x > 0 && !visited[x - 1][y] && cabbage[x - 1][y] == 1)
            count += bfs(x - 1, y);
        if (y > 0 && !visited[x][y - 1] && cabbage[x][y - 1] == 1)
            count += bfs(x, y - 1);
        if (x < n - 1 && !visited[x + 1][y] && cabbage[x + 1][y] == 1)
            count += bfs(x + 1, y);
        if (y < m - 1 && !visited[x][y + 1] && cabbage[x][y + 1] == 1)
            count += bfs(x, y + 1);

        return count;
    }
}

