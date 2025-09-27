import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        while (true) {
            if (check(arr)) {
                System.out.println(count);
                return;
            }
            count++;
            if (isEven(arr))
                for (int i = 0; i < arr.length; i++)
                    arr[i] /= 2;
            else
                for (int i = 0; i < arr.length; i++)
                    if(arr[i] % 2 != 0) {
                        arr[i]--;
                        break;
                    }
        }
    }

    public static boolean isEven(int[] arr) {
        for (int i : arr)
            if (i % 2 != 0)
                return false;
        return true;
    }

    public static boolean check(int[] arr) {
        for (int i : arr)
            if (i != 0)
                return false;
        return true;
    }
}