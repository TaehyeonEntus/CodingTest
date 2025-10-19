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

            int y = -1;
            for(int i = 0; i < n; i++)
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int i = 0; i < n; i++)
                if(map[n-1][i] == 2) {
                    y = i;
                    break;
                }

            for(int i = n-1; i >= 0; i--) {
                int left = y-1;
                int right = y+1;

                if(left >= 0 && map[i][left] == 1){
                    while (left >= 0 && map[i][left] == 1) {
                        y = left;
                        left--;
                    }
                } else if(right < n && map[i][right] == 1){
                    while (right < n && map[i][right] == 1) {
                        y = right;
                        right++;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(y).append("\n");
        }
        System.out.println(sb);
    }
}