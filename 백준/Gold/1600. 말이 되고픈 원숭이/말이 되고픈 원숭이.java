import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Node> queue = new ArrayDeque<>();

    static int n;
    static int m;

    static int[][] map;
    static boolean[][][] visited;

    static int[] horse_dx = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] horse_dy = {-1, 1, 2, 2, 1, -1, -2, -2};

    static int[] monkey_dx = {-1, 1, 0, 0};
    static int[] monkey_dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        int hop = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];

        map = new int[m][n];
        visited = new boolean[hop + 1][m][n];

        for (int i = 0; i < m; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        visited[hop][0][0] = true;
        queue.add(new Node(0, 0, 0, hop));

        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x;
            int y;
            int count = node.count;
            int hop = node.hop;

            if (node.x == m - 1 && node.y == n - 1)
                return count;

            //monkey move
            for (int i = 0; i < 4; i++) {
                x = node.x + monkey_dx[i];
                y = node.y + monkey_dy[i];

                if ((x < 0 || x >= m || y < 0 || y >= n) || visited[hop][x][y] || map[x][y] == 1)
                    continue;

                visited[hop][x][y] = true;
                queue.add(new Node(x, y, count + 1, hop));
            }

            //horse move
            if (hop > 0)
                for (int i = 0; i < 8; i++) {
                    x = node.x + horse_dx[i];
                    y = node.y + horse_dy[i];

                    if ((x < 0 || x >= m || y < 0 || y >= n) || visited[hop - 1][x][y] || map[x][y] == 1)
                        continue;

                    visited[hop - 1][x][y] = true;
                    queue.add(new Node(x, y, count + 1, hop - 1));
                }
        }
        return -1;
    }

    public static class Node {
        int x;
        int y;
        int count;
        int hop;

        public Node(int x, int y, int count, int hop) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.hop = hop;
        }
    }
}