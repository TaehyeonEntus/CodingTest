import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Node> queue = new ArrayDeque<>();

    static int n;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs());
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static String bfs() {
        int color_3 = 0;
        int color_2 = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    char color = map[i][j];
                    visited[i][j] = true;
                    queue.add(new Node(i, j));

                    while (!queue.isEmpty()) {
                        Node node = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = node.x + dx[k];
                            int y = node.y + dy[k];
                            if ((x >= 0 && x < n && y >= 0 && y < n)) {
                                boolean colorMatch = (color == map[x][y]);
                                if (!visited[x][y] && colorMatch) {
                                    visited[x][y] = true;
                                    queue.add(new Node(x, y));
                                }
                            }
                        }
                    }
                    color_3++;
                }
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    char color = map[i][j];
                    visited[i][j] = true;
                    queue.add(new Node(i, j));

                    while (!queue.isEmpty()) {
                        Node node = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = node.x + dx[k];
                            int y = node.y + dy[k];
                            if ((x >= 0 && x < n && y >= 0 && y < n)) {
                                boolean colorMatch = (color == map[x][y]) || (color == 'R' && map[x][y] == 'G') || (color == 'G' && map[x][y] == 'R');
                                if (!visited[x][y] && colorMatch) {
                                    visited[x][y] = true;
                                    queue.add(new Node(x, y));
                                }
                            }
                        }
                    }
                    color_2++;
                }
            }
        }

        return color_3 + " " + color_2;
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