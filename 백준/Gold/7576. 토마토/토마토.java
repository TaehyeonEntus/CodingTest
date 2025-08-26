import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Node> queue = new ArrayDeque<>();
    static int[][] board;
    static boolean[][] visited;

    static int n;
    static int m;


    public static void main(String[] args) throws IOException {
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[1];
        m = nm[0];
        visited = new boolean[n][m];
        board = new int[n][m];
        for (int i = 0; i < n; i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (board[i][j] == -1)
                    visited[i][j] = true;

                if (board[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(new Node(i, j, 0));
                }
            }

        boolean hasUnripe = false;
        boolean hasRipe = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == -1) {
                    visited[i][j] = true; // 빈칸
                } else if (board[i][j] == 1) {
                    visited[i][j] = true; // 익은 토마토
                    queue.add(new Node(i, j, 0));
                    hasRipe = true;
                } else if (board[i][j] == 0) {
                    hasUnripe = true; // 안 익은 토마토
                }
            }
        }

        // 1. 익은 토마토가 하나도 없는데 안 익은 게 있으면 -1
        if (!hasRipe && hasUnripe) {
            System.out.println(-1);
            return;
        }

        // 2. 처음부터 모두 익어있으면 0
        if (hasRipe && !hasUnripe) {
            System.out.println(0);
            return;
        }

        int count = bfs();

        // 3. BFS 끝나고 안 익은 토마토가 남아 있으면 -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);
    }

    public static int bfs() {
        int maxCount = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int x = node.nx;
            int y = node.ny;
            int count = node.count;

            maxCount = Math.max(maxCount, count);

            if (x > 0 && !visited[x - 1][y] && board[x - 1][y] == 0) {
                visited[x - 1][y] = true;
                queue.add(new Node(x - 1, y, count + 1));
            }

            if (y > 0 && !visited[x][y - 1] && board[x][y - 1] == 0) {
                visited[x][y - 1] = true;
                queue.add(new Node(x, y - 1, count + 1));
            }

            if (x < n - 1 && !visited[x + 1][y] && board[x + 1][y] == 0) {
                visited[x + 1][y] = true;
                queue.add(new Node(x + 1, y, count + 1));
            }

            if (y < m - 1 && !visited[x][y + 1] && board[x][y + 1] == 0) {
                visited[x][y + 1] = true;
                queue.add(new Node(x, y + 1, count + 1));
            }

        }
        return maxCount;
    }

    public static class Node {
        int nx;
        int ny;
        int count;

        public Node(int nx, int ny, int count) {
            this.nx = nx;
            this.ny = ny;
            this.count = count;
        }
    }
}

