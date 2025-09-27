import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n; //세로
    static int m; //가로
    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static final int N = 0;
    static final int E = 1;
    static final int S = 2;
    static final int W = 3;

    static int dir;
    static int i;
    static int j;

    public static void main(String[] args) throws IOException {
        int[] arr;

        int count = 0;

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];

        map = new int[n][m];

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        i = arr[0];
        j = arr[1];

        dir = arr[2];

        for (int p = 0; p < n; p++) {
            map[p] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        while (true) {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                count++;
            }
            if (checkAround()) {
                spin();
                if (checkFront())
                    moveFront();
            } else {
                if (checkBack())
                    moveBack();
                else
                    break;
            }
        }
        System.out.println(count);
    }

    public static void spin() {
        dir--;
        if (dir == -1)
            dir = 3;
    }

    public static boolean checkAround() {
        int x;
        int y;
        for (int k = 0; k < 4; k++) {
            x = i + dx[k];
            y = j + dy[k];
            if (map[x][y] == 0)
                return true;
        }
        return false;
    }

    public static boolean checkFront() {
        int x = i + dx[dir];
        int y = j + dy[dir];
        if (map[x][y] == 1)
            return false;
        return map[x][y] == 0;
    }

    public static void moveFront() {
        i += dx[dir];
        j += dy[dir];
    }

    public static boolean checkBack() {
        int x = i - dx[dir];
        int y = j - dy[dir];
        return map[x][y] != 1;
    }

    public static void moveBack() {
        i -= dx[dir];
        j -= dy[dir];
    }
}