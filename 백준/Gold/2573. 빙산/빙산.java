import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Node> queue = new ArrayDeque<Node>();
    static int n;
    static int m;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[][] map;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        map = new int[n][m];

        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int flag = countIce(map);
        int[][] temp = meltIce(map);
        int year = 1;

        while (flag == -1) {
            temp = meltIce(temp);
            flag = countIce(temp);
            year++;
        }
        System.out.println(flag == 0 ? flag : year);
    }

    public static int countIce(int[][] map) {
        //-1 -> 아직 남음
        // 0 -> 모두 녹음
        // 1 -> 2개 이상 덩이

        int tempX = -1;
        int tempY = -1;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    tempX = i;
                    tempY = j;
                } else {
                    visited[i][j] = true;
                }
            }
        }

        if (tempX == -1 && tempY == -1)
            return 0;

        queue.add(new Node(tempX, tempY));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            if (visited[x][y])
                continue;
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!visited[nx][ny] && map[nx][ny] != 0) {
                    queue.add(new Node(nx, ny));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    return 1;
                }
            }
        }
        return -1;
    }

    public static int[][] meltIce(int[][] map) {
        int[][] answerMap = new int[n][m];
        for (int i = 0; i < n; i++)
            answerMap[i] = map[i].clone();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if (x < 0 || x >= n || y < 0 || y >= m)
                            continue;

                        answerMap[x][y]--;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (answerMap[i][j] < 0) {
                    answerMap[i][j] = 0;
                }
            }
        }
        return answerMap;
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