import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static int n;
    static int m;
    static int h;
    static int min = Integer.MAX_VALUE;
    static List<Radder> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        h = arr[2];

        map = new int[h][n];
        for (int i = 0; i < m; i++) {
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = arr[0] - 1;
            int y = arr[1] - 1;
            map[x][y] = 1;
            map[x][y + 1] = -1;
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 || map[i][j] == -1)
                    continue;
                list.add(new Radder(i, j));
            }
        }

        dfs(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void dfs(int depth, int start) {
        if (depth > 3)
            return;

        if (checkRadder()) {
            min = Math.min(min, depth);
            return;
        }

        for (int i = start; i < list.size(); i++) {
            Radder radder = list.get(i);
            int x = radder.x;
            int y = radder.y;
            if (map[x][y] == -1)
                continue;

            if (y + 1 == n)
                continue;

            if (map[x][y + 1] == 1)
                continue;

            map[x][y] = 1;
            map[x][y + 1] = -1;
            dfs(depth + 1, i + 1);
            map[x][y] = 0;
            map[x][y + 1] = 0;
        }
    }

    public static boolean checkRadder() {
        for (int i = 0; i < n; i++) {
            int end = i;
            for (int j = 0; j < h; j++) {
                if (map[j][end] == 1) {
                    end++;
                } else if (map[j][end] == -1) {
                    end--;
                }
            }
            if (end != i)
                return false;
        }
        return true;
    }

    public static class Radder {
        int x;
        int y;

        public Radder(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
