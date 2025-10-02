import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] map;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(0, map);

        System.out.println(max);
    }

    public static void dfs(int depth, int[][] map) {
        if (depth == 5) {
            for(int i = 0; i<n; i++)
                for(int j = 0; j<n; j++)
                    max = Math.max(max, map[i][j]);
            return;
        }

        int[][] leftMap = new int[n][n];
        int[][] rightMap = new int[n][n];
        int[][] upMap = new int[n][n];
        int[][] downMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            int leftIndex = 0;
            int rightIndex = n - 1;
            int upIndex = 0;
            int downIndex = n - 1;

            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    continue;
                } else if (leftMap[i][leftIndex] == 0) {
                    leftMap[i][leftIndex] = map[i][j];
                } else if (leftMap[i][leftIndex] == map[i][j]) {
                    leftMap[i][leftIndex++] *= 2;
                } else {
                    leftMap[i][++leftIndex] = map[i][j];
                }
            }

            for (int j = 0; j < n; j++) {
                if (map[j][i] == 0) {
                    continue;
                } else if (upMap[upIndex][i] == 0) {
                    upMap[upIndex][i] = map[j][i];
                } else if (upMap[upIndex][i] == map[j][i]) {
                    upMap[upIndex++][i] *= 2;
                } else {
                    upMap[++upIndex][i] = map[j][i];
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (map[n - i - 1][j] == 0) {
                    continue;
                } else if (rightMap[n - i - 1][rightIndex] == 0) {
                    rightMap[n - i - 1][rightIndex] = map[n - i - 1][j];
                } else if (rightMap[n - i - 1][rightIndex] == map[n - i - 1][j]) {
                    rightMap[n - i - 1][rightIndex--] *= 2;
                } else {
                    rightMap[n - i - 1][--rightIndex] = map[n - i - 1][j];
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (map[j][n - i - 1] == 0) {
                    continue;
                } else if (downMap[downIndex][n - i - 1] == 0) {
                    downMap[downIndex][n - i - 1] = map[j][n - i - 1];
                } else if (downMap[downIndex][n - i - 1] == map[j][n - i - 1]) {
                    downMap[downIndex--][n - i - 1] *= 2;
                } else {
                    downMap[--downIndex][n - i - 1] = map[j][n - i - 1];
                }
            }
        }

        dfs(depth + 1, leftMap);
        dfs(depth + 1, upMap);
        dfs(depth + 1, rightMap);
        dfs(depth + 1, downMap);
    }
}

