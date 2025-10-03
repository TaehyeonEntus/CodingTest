import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int gap = arr[1] - arr[0];
            double sqrt = Math.sqrt(gap);
            boolean isPerfectSquare = sqrt % 1 == 0;

            int answer = 0;

            int floor = (int)Math.floor(sqrt);
            int ceil = (int)Math.ceil(sqrt);
            int value = (int)Math.round(sqrt);
            if(isPerfectSquare){
                answer = value * 2 -1;
            } else if (floor == value){
                answer = value * 2;
            } else if(ceil == value){
                answer = floor * 2 + 1;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}