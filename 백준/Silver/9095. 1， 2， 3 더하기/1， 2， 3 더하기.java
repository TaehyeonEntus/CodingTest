import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[t];

        for(int i = 0; i < t; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Arrays.stream(arr).max().getAsInt();

        int[] dp = new int[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i <= max; i++) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }

        for(int a : arr){
            System.out.println(dp[a]);
        }
    }
}