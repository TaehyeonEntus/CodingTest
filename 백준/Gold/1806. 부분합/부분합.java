import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = arr[0];
        int s = arr[1];

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int length = 1_000_000_000;
        int sum = 0;
        int left = 0;
        int right = 0;

        while (right<=n){
            if(sum < s) {
                if(right == n)
                    break;
                sum += arr[right++];
            }
            else {
                length = Math.min(length, right-left);
                sum -= arr[left++];
            }
        }

        System.out.println(length==1_000_000_000?0:length);
    }
}