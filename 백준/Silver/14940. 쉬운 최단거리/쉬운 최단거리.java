import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Node> queue = new ArrayDeque<>();
    static boolean[][] visited;
    static int[][] map;
    static int[][] dp;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        visited = new boolean[n][m];
        dp = new int[n][m];
        for (int[] dpArr : dp)
            Arrays.fill(dpArr, -1);
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int startX = 0;
        int startY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }

        Node startNode = new Node(startX, startY);
        dp[startX][startY] = 0;
        visited[startX][startY] = true;
        queue.add(startNode);

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int target = dp[i][j];
                if (target == -1) {
                    if (map[i][j] == 0)
                        target = 0;
                }
                System.out.print(target+" ");
            }
            System.out.println();
        }
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            if (x >= 1 && !visited[x - 1][y] && map[x - 1][y] != 0) {
                visited[x - 1][y] = true;
                dp[x - 1][y] = dp[x][y] + 1;
                queue.add(new Node(x - 1, y));
            }

            if (y >= 1 && !visited[x][y - 1] && map[x][y - 1] != 0) {
                visited[x][y - 1] = true;
                dp[x][y - 1] = dp[x][y] + 1;
                queue.add(new Node(x, y - 1));
            }

            if (x < n - 1 && !visited[x + 1][y] && map[x + 1][y] != 0) {
                visited[x + 1][y] = true;
                dp[x + 1][y] = dp[x][y] + 1;
                queue.add(new Node(x + 1, y));
            }

            if (y < m - 1 && !visited[x][y + 1] && map[x][y + 1] != 0) {
                visited[x][y + 1] = true;
                dp[x][y + 1] = dp[x][y] + 1;
                queue.add(new Node(x, y + 1));
            }
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

