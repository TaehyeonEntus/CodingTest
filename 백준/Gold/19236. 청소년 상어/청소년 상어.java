import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] fishMap = new int[4][4];
    static int[][] dirMap = new int[4][4];
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};

    static int max = 0;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 4; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 8; j++) {
                if (j % 2 == 0)
                    fishMap[i][j / 2] = arr[j];
                else
                    dirMap[i][j / 2] = arr[j];
            }
        }
        dfs(0, 0, fishMap, dirMap, 0);
        System.out.println(max);
    }

    public static void dfs(int x, int y, int[][] fishMap, int[][] dirMap, int total) {
        total += fishMap[x][y];
        max = Math.max(max, total);

        fishMap[x][y] = -1;

        moveFish(fishMap, dirMap);

        for (int step = 1; step <= 3; step++) {
            if (canSharkMove(x, y, step, fishMap, dirMap)) {
                int[][] newFishMap = new int[4][4];
                int[][] newDirMap = new int[4][4];

                for (int i = 0; i < 4; i++) {
                    System.arraycopy(fishMap[i], 0, newFishMap[i], 0, 4);
                    System.arraycopy(dirMap[i], 0, newDirMap[i], 0, 4);
                }

                newFishMap[x][y] = 0;
                dfs(x + dx[dirMap[x][y]] * step, y + dy[dirMap[x][y]] * step, newFishMap, newDirMap, total);
            }
        }
    }

    public static void moveFish(int[][] newFishMap, int[][] newDirMap) {
        for (int i = 1; i <= 16; i++) {
            int x = -1, y = -1;

            outer: for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (newFishMap[j][k] == i) {
                        x = j;
                        y = k;
                        break outer;
                    }
                }
            }

            if (x == -1) continue;

            for (int t = 0; t < 8; t++) {
                if (canFishMove(x, y, newFishMap, newDirMap)) {
                    swap(x, y, newFishMap, newDirMap);
                    break;
                } else {
                    spin(x, y, newDirMap);
                }
            }
        }
    }

    public static boolean canFishMove(int x, int y, int[][] fishMap, int[][] dirMap) {
        int dir = dirMap[x][y];
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) return false;
        return fishMap[nx][ny] != -1;
    }

    public static boolean canSharkMove(int x, int y, int step, int[][] fishMap, int[][] dirMap) {
        int dir = dirMap[x][y];
        int nx = x + dx[dir] * step;
        int ny = y + dy[dir] * step;

        if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) return false;
        return fishMap[nx][ny] != 0;
    }

    public static void swap(int a_x, int a_y, int[][] newFishMap, int[][] newDirMap) {
        int dir = newDirMap[a_x][a_y];
        int b_x = a_x + dx[dir];
        int b_y = a_y + dy[dir];

        int temp = newFishMap[a_x][a_y];
        newFishMap[a_x][a_y] = newFishMap[b_x][b_y];
        newFishMap[b_x][b_y] = temp;

        int temp2 = newDirMap[a_x][a_y];
        newDirMap[a_x][a_y] = newDirMap[b_x][b_y];
        newDirMap[b_x][b_y] = temp2;
    }

    public static void spin(int x, int y, int[][] newDirMap) {
        newDirMap[x][y]++;
        if (newDirMap[x][y] == 9)
            newDirMap[x][y] = 1;
    }
}