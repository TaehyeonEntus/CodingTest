import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Node> queue = new ArrayDeque<>();
    static char[][] map;
    static boolean[][] visited;
    static int n;
    static int m;
    static int person = 0;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        map = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            map[i] = br.readLine().toCharArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'I') {
                    visited[i][j] = true;
                    queue.add(new Node(i, j));
                    break;
                }
            }
            if (!queue.isEmpty())
                break;
        }

        bfs();

        System.out.println(person!=0?person:"TT");
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (map[node.x][node.y] == 'P')
                person++;

            for (int dir = 0; dir < 4; dir++) {
                //다음 좌표
                int x = node.x + dx[dir];
                int y = node.y + dy[dir];

                //n * m 평면 내부 검사
                if (x >= 0 && x <= n - 1 && y >= 0 && y <= m - 1)
                    //X 이거나 방문한 노드는 추가 X
                    if (map[x][y] != 'X' && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.add(new Node(x, y));
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
    }
}