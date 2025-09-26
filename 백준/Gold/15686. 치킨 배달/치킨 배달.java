import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[][] map;
    static List<Node> chicken = new ArrayList<>();
    static Deque<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) {
                    chicken.add(new Node(i, j, 0));
                    map[i][j] = 0;
                }
            }
        }

        dfs(0, 0);

        System.out.println(min);
    }

    public static void dfs(int depth, int start) {
        if (depth == m) {
            bfs();
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            Node node = chicken.get(i);
            map[node.x][node.y] = 2;
            visited[node.x][node.y] = true;
            dfs(depth + 1, i + 1);
            map[node.x][node.y] = 0;
            visited[node.x][node.y] = false;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void bfs() {
        boolean[][] visitedBFS = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visitedBFS[i][j] = visited[i][j];
            }
        }

        queue.clear();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) {
                    queue.add(new Node(i, j, 0));
                }
            }
        }

        int total = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int step = node.step;

            if (map[x][y] == 1)
                total += step;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                if (!visitedBFS[nx][ny]) {
                    queue.add(new Node(nx, ny, step + 1));
                    visitedBFS[nx][ny] = true;
                }
            }
        }

        min = Math.min(min, total);
    }


    public static class Node {
        int x;
        int y;
        int step;

        public Node(int x, int y, int step) {
            this.y = y;
            this.x = x;
            this.step = step;
        }
    }
}