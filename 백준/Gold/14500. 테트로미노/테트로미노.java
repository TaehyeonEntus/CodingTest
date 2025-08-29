import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                dfs(i, j, 1, map[i][j]);

        solve();

        System.out.println(max);
    }

    static int max = 0;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }
        visited[x][y] = true;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;
            if (!visited[nx][ny])
                dfs(nx, ny, depth + 1, sum + map[nx][ny]);
        }
        visited[x][y] = false;
    }

    public static void solve(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (i <= n - 2 && j >= 1 && j <= m - 2) {
                    int sum = map[i][j] + map[i][j-1] + map[i][j+1] + map[i+1][j];
                    max = Math.max(max, sum);
                }

                if (i >= 1 && j >= 1 && j <= m - 2) {
                    int sum = map[i][j] + map[i][j-1] + map[i][j+1] + map[i-1][j];
                    max = Math.max(max, sum);
                }

                if (i >= 1 && i <= n - 2 && j <= m - 2) {
                    int sum = map[i][j] + map[i-1][j] + map[i+1][j] + map[i][j+1];
                    max = Math.max(max, sum);
                }

                if (i >= 1 && i <= n - 2 && j >= 1) {
                    int sum = map[i][j] + map[i-1][j] + map[i+1][j] + map[i][j-1];
                    max = Math.max(max, sum);
                }
            }
        }
    }
}


