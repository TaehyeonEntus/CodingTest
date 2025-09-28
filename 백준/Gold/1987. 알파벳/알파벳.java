import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int r;
    static int c;
    static char[][] map;
    static boolean[] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int count = 1;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        int[] arr;
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        r = arr[0];
        c = arr[1];
        map = new char[r][c];
        visited = new boolean[26];
        for (int i = 0; i < r; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < c; j++)
                map[i][j] = charArray[j];
        }
        visited[map[0][0] - 'A'] = true;
        dfs(0,0);

        System.out.println(max);
    }

    public static void dfs(int X, int Y) {
        max = Math.max(max, count);
        for (int dir = 0; dir < 4; dir++) {
            int x = X + dx[dir];
            int y = Y + dy[dir];
            if (x < 0 || x >= r || y < 0 || y >= c) continue;
            if(!visited[map[x][y] - 'A']){
                visited[map[x][y] - 'A'] = true;
                count++;
                dfs(x, y);
                visited[map[x][y] - 'A'] = false;
                count--;
            }
        }
    }
}