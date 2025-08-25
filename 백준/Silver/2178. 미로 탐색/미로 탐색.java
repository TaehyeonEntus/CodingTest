import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] miro;
    static boolean[][] visited;
    static Deque<Node> queue;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];

        queue = new ArrayDeque<>();
        miro = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] charArr = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                miro[i][j] = Character.getNumericValue(charArr[j]);
            }
        }

        visited[0][0] = true;
        queue.add(new Node(0, 0, 1));

        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int x = node.nx;
            int y = node.ny;
            int count = node.count;

            if (x == n - 1 && y == m - 1)
                return count;


            if (x > 0 && !visited[x - 1][y] && miro[x - 1][y] == 1) {
                visited[x - 1][y] = true;
                queue.add(new Node(x - 1, y, count + 1));
            }

            if (x < n - 1 && !visited[x + 1][y] && miro[x + 1][y] == 1) {
                visited[x + 1][y] = true;
                queue.add(new Node(x + 1, y, count + 1));
            }

            if (y > 0 && !visited[x][y - 1] && miro[x][y - 1] == 1) {
                visited[x][y - 1] = true;
                queue.add(new Node(x, y - 1, count + 1));
            }
            
            if (y < m - 1 && !visited[x][y + 1] && miro[x][y + 1] == 1) {
                visited[x][y + 1] = true;
                queue.add(new Node(x, y + 1, count + 1));
            }
        }
        return -1;
    }

    public static class Node {
        int nx;
        int ny;

        public Node(int nx, int ny, int count) {
            this.nx = nx;
            this.ny = ny;
            this.count = count;
        }

        int count;
    }
}

