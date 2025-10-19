import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int high;
    static int low;

    static int[] height;
    public static void main(String[] args) throws IOException {
        for(int i = 1; i <= 10; i++) {
            int n = Integer.parseInt(br.readLine());
            height = new int[100+1];
            high = Integer.MIN_VALUE;
            low = Integer.MAX_VALUE;
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int dump : arr){
                high = Math.max(high, dump);
                low = Math.min(low, dump+1);
                for(int j = 0; j <= dump; j++)
                    height[j]++;
            }

            for(int count = 0; count < n; count++){
                height[high]--;
                height[low]++;

                if(height[high] == 0)
                    high--;
                if(height[low] == arr.length)
                    low++;

                if(high <= low)
                    break;
            }

            sb.append("#").append(i).append(" ").append(Math.abs(high-low+1)).append("\n");
        }
        System.out.println(sb);
    }
}