import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Ingredient> list = new ArrayList<>();
    static int max;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            list.clear();
            max = 0;
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = arr[0];
            int m = arr[1];
            for(int i = 0; i<n; i++){
                arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                list.add(new Ingredient(arr[0], arr[1]));
            }

            int[][] dp = new int[n+1][m+1];

            for(int i = 1; i<=n; i++){
                Ingredient ingredient = list.get(i-1);
                for(int j = 0; j<=m; j++){
                    //안넣는 경우
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                    //넣는 경우
                    if(j+ingredient.calorie <= m)
                        dp[i][j+ingredient.calorie] = Math.max(dp[i][j+ingredient.calorie], dp[i-1][j] + ingredient.point);
                }
            }
            for(int values : dp[n])
                max = Math.max(max, values);
            sb.append("#").append(t).append(" ").append(max).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static class Ingredient{
        int point;
        int calorie;

        public Ingredient(int point, int calorie) {
            this.point = point;
            this.calorie = calorie;
        }
    }
}