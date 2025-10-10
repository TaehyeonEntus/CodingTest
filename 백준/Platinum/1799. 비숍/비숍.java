import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] map;
    static int[][] whiteMap;
    static int[][] blackMap;
    static int whiteMax = 0;
    static int blackMax = 0;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};

    static List<Pair> whiteList = new ArrayList<>();
    static List<Pair> blackList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        whiteMap = new int[n][n];
        blackMap = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    whiteMap[i][j] = map[i][j];
                    if (map[i][j] == 1)
                        whiteList.add(new Pair(i, j));
                } else {
                    blackMap[i][j] = map[i][j];
                    if (map[i][j] == 1)
                        blackList.add(new Pair(i, j));
                }
            }

        whiteDfs(0, 0);
        blackDfs(0, 0);
        System.out.println(whiteMax + blackMax);
    }

    public static void whiteDfs(int depth, int start) {
        if (!canPutWhiteBishop()) {
            whiteMax = Math.max(whiteMax, depth);
            return;
        }

        for (int k = start; k < whiteList.size(); k++) {
            Pair p = whiteList.get(k);
            int i = p.x;
            int j = p.y;
            if (whiteMap[i][j] == 1) {
                setWhiteBishop(i, j);
                whiteDfs(depth + 1, k + 1);
                getWhiteBishop(i, j);
            }
        }
    }

    public static void blackDfs(int depth, int start) {
        if (!canPutBlackBishop()) {
            blackMax = Math.max(blackMax, depth);
            return;
        }

        for (int k = start; k < blackList.size(); k++) {
            Pair p = blackList.get(k);
            int i = p.x;
            int j = p.y;
            if (blackMap[i][j] == 1) {
                setBlackBishop(i, j);
                blackDfs(depth + 1, k + 1);
                getBlackBishop(i, j);
            }
        }
    }


    public static void setWhiteBishop(int x, int y) {
        whiteMap[x][y]--;
        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;
            while (true) {
                nx += dx[i];
                ny += dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
                whiteMap[nx][ny]--;
            }
        }
    }

    public static void setBlackBishop(int x, int y) {
        blackMap[x][y]--;
        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;
            while (true) {
                nx += dx[i];
                ny += dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
                blackMap[nx][ny]--;
            }
        }
    }

    public static void getWhiteBishop(int x, int y) {
        whiteMap[x][y]++;
        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;
            while (true) {
                nx += dx[i];
                ny += dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
                whiteMap[nx][ny]++;
            }
        }
    }

    public static void getBlackBishop(int x, int y) {
        blackMap[x][y]++;
        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;
            while (true) {
                nx += dx[i];
                ny += dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
                blackMap[nx][ny]++;
            }
        }
    }

    public static boolean canPutWhiteBishop() {
        for (Pair p : whiteList)
            if (whiteMap[p.x][p.y] == 1)
                return true;
        return false;
    }

    public static boolean canPutBlackBishop() {
        for (Pair p : blackList)
            if (blackMap[p.x][p.y] == 1)
                return true;
        return false;
    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}