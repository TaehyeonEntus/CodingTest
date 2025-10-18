import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = arr[0];
            int m = arr[1];

            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++)
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int max = 0;
            if (n == m) {
                int total = 0;
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++)
                        total += map[i][j];
                max = total;
            } else {
                for (int i = 0; i <= n - m; i++) {
                    for (int j = 0; j <= n - m; j++) {
                        int total = 0;
                        for (int x = i; x < i + m; x++) {
                            for (int y = j; y < j + m; y++) {
                                total += map[x][y];
                            }
                        }
                        max = Math.max(max, total);
                    }
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb.toString());
    }
}