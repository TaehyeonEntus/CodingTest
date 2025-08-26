import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] board;
    static boolean[][] visited;
    static Deque<Node> queue;
    static int n;

    static int startX;
    static int startY;

    static int targetX;
    static int targetY;


    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int T = 0; T < t; T++) {
            n = Integer.parseInt(br.readLine());

            int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            startX = start[0];
            startY = start[1];

            targetX = target[0];
            targetY = target[1];

            queue = new ArrayDeque<>();
            board = new int[n][n];
            visited = new boolean[n][n];

            visited[startX][startY] = true;
            queue.add(new Node(startX, startY, 0));

            System.out.println(bfs());
        }
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int x = node.nx;
            int y = node.ny;
            int count = node.count;

            if (x == targetX && y == targetY)
                return count;

            if (x >= 2 && y >= 1 && !visited[x - 2][y - 1]) {
                visited[x - 2][y - 1] = true;
                queue.add(new Node(x - 2, y - 1, count + 1));
            }

            if (x >= 2 && y + 1 < n && !visited[x - 2][y + 1]) {
                visited[x - 2][y + 1] = true;
                queue.add(new Node(x - 2, y + 1, count + 1));
            }

            if (x >= 1 && y >= 2 && !visited[x - 1][y - 2]) {
                visited[x - 1][y - 2] = true;
                queue.add(new Node(x - 1, y - 2, count + 1));
            }

            if (x >= 1 && y + 2 < n && !visited[x - 1][y + 2]) {
                visited[x - 1][y + 2] = true;
                queue.add(new Node(x - 1, y + 2, count + 1));
            }

            if (x + 1 < n && y >= 2 && !visited[x + 1][y - 2]) {
                visited[x + 1][y - 2] = true;
                queue.add(new Node(x + 1, y - 2, count + 1));
            }

            if (x + 1 < n && y + 2 < n && !visited[x + 1][y + 2]) {
                visited[x + 1][y + 2] = true;
                queue.add(new Node(x + 1, y + 2, count + 1));
            }

            if (x + 2 < n && y >= 1 && !visited[x + 2][y - 1]) {
                visited[x + 2][y - 1] = true;
                queue.add(new Node(x + 2, y - 1, count + 1));
            }

            if (x + 2 < n && y + 1 < n && !visited[x + 2][y + 1]) {
                visited[x + 2][y + 1] = true;
                queue.add(new Node(x + 2, y + 1, count + 1));
            }
        }
        return -1;
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

