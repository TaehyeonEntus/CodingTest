import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int dir;

    static boolean[][] visited;
    static int[][] map;

    static int x;
    static int y;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append("\n");

            n = Integer.parseInt(br.readLine());
            dir = 1;
            map = new int[n][n];
            visited = new boolean[n][n];

            x = 0;
            y = 0;

            visited[0][0] = true;
            snail(1);

            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void snail(int count) {
        map[x][y] = count;

        if (count == n * n) {
            return;
        }

        int next_x = x + dx[dir];
        int next_y = y + dy[dir];

        if (next_x < 0 || next_y < 0 || next_x >= n || next_y >= n) {
            turn();
            snail(count);
        } else if(visited[next_x][next_y]) {
            turn();
            snail(count);
        } else {
            x = next_x;
            y = next_y;
            visited[x][y] = true;
            snail(count+1);
        }
    }

    public static void turn() {
        dir++;
        if (dir == 4)
            dir = 0;
    }
}