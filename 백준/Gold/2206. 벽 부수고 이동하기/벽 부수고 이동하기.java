import org.w3c.dom.Node;

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
    static boolean[][] visited;
    static boolean[][] visitedBreak;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        map = new int[n][m];
        visited = new boolean[n][m];
        visitedBreak = new boolean[n][m];
        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        visited[0][0] = true;
        queue.add(new Node(0, 0, 1, false));

        System.out.println(bfs());
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static int bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == n - 1 && node.y == m - 1)
                return node.count;

            for (int i = 0; i < 4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];
                //1. 범위 계산
                if ((x >= 0 && x < n) && (y >= 0 && y < m)) {
                    //2. 벽을 부쉈는지 구분
                    //부순경우
                    if (node.breakWall) {
                        if (!visitedBreak[x][y] && map[x][y] == 0) {
                            visitedBreak[x][y] = true;
                            queue.add(new Node(x, y, node.count + 1, true));
                        }
                    }
                    //안부순경우
                    else {
                        if (!visited[x][y]) {
                            if (map[x][y] == 1) {
                                visited[x][y] = true;
                                visitedBreak[x][y] = true;
                                queue.add(new Node(x, y, node.count + 1, true));
                            } else {
                                visited[x][y] = true;
                                queue.add(new Node(x, y, node.count + 1, false));
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static class Node {
        int x;
        int y;
        int count;
        boolean breakWall;

        public Node(int x, int y, int count, boolean breakWall) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.breakWall = breakWall;
        }
    }
}