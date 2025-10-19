import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        for(int t = 1; t <= 10; t++) {
            int number = Integer.parseInt(br.readLine());

            int n = 100;

            int[][] map = new int[n][n];
            for(int i = 0; i < n; i++)
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int maxValue = Integer.MIN_VALUE;

            for(int i = 0; i < n; i++){
                int sum_x = 0;
                int sum_y = 0;
                for(int j = 0; j < n; j++) {
                    sum_x += map[i][j];
                    sum_y += map[j][i];
                }
                maxValue = Math.max(maxValue, sum_x);
                maxValue = Math.max(maxValue, sum_y);
            }

            int topLeftToBottomRight = 0;
            for(int i = 0; i < n; i++)
                topLeftToBottomRight += map[i][i];

            int topRightToBottomLeft = 0;
            for(int i = 0; i < n; i++)
                topRightToBottomLeft += map[i][n-i-1];

            maxValue = Math.max(maxValue, topLeftToBottomRight);
            maxValue = Math.max(maxValue, topRightToBottomLeft);

            sb.append("#").append(t).append(" ").append(maxValue).append("\n");
        }
        System.out.println(sb);
    }
}