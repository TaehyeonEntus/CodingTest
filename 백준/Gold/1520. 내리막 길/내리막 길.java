import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getValue).reversed());
    static int n;
    static int m;


    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[][] map;
    static int[][] dp;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        map = new int[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dp[0][0] = 1;
        pq.add(new Node(0, 0));
        bfs();
        System.out.println(dp[n - 1][m - 1]);
    }

    public static void bfs() {
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int X = node.x;
            int Y = node.y;
            if (visited[X][Y]) continue;
            visited[X][Y] = true;

            for (int i = 0; i < 4; i++) {
                int x = X + dx[i];
                int y = Y + dy[i];

                if (x < 0 || x >= n || y < 0 || y >= m)
                    continue;
                if (map[X][Y] > map[x][y]) {
                    dp[x][y] += dp[X][Y];
                    pq.add(new Node(x, y));
                }
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

        public int getValue() {
            return map[x][y];
        }
    }
}