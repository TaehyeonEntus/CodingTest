import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Node> queue = new ArrayDeque<>();
    static int n;
    static int m;
    static int[][] map;
    static int[][] virusMap;
    static boolean[][] visited;
    static int minVirus = 1_000_000_000;
    static int wall = 0;
    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        map = new int[n][m];
        virusMap = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (map[i][j] != 0) {
                    if(map[i][j] == 1)
                        wall++;
                    visited[i][j] = true;
                }

        dfs(0);

        System.out.println(n*m - wall-3 - minVirus);
    }

    public static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                    visited[i][j] = false;
                }
            }
        }
    }

    public static void bfs() {
        for (int i = 0; i < n; i++){
            virusMap[i] = map[i].clone();
            for (int j = 0; j < m; j++)
                if (virusMap[i][j] == 2) queue.add(new Node(i, j));
        }


        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            if (x > 0 && virusMap[x - 1][y] == 0) {
                virusMap[x - 1][y] = 2;
                queue.add(new Node(x - 1, y));
            }
            if (y > 0 && virusMap[x][y - 1] == 0) {
                virusMap[x][y - 1] = 2;
                queue.add(new Node(x, y - 1));
            }
            if (x < n - 1 && virusMap[x + 1][y] == 0) {
                virusMap[x + 1][y] = 2;
                queue.add(new Node(x + 1, y));
            }
            if (y < m - 1 && virusMap[x][y + 1] == 0) {
                virusMap[x][y + 1] = 2;
                queue.add(new Node(x, y + 1));
            }
        }

        int sumVirus = 0;
        for(int[] virusMapArr : virusMap)
            for(int virus : virusMapArr)
                if(virus == 2)
                    sumVirus++;

        minVirus = Math.min(sumVirus, minVirus);
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


