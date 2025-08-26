import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int h = arr[0];
            int w = arr[1];
            int target = arr[2];

            int start = target % h;
            int end = target / h;
            if(start == 0)
                start = h;
            else
                end++;

            if(end>=10)
                System.out.println(start+""+end);
            else
                System.out.println(start+"0"+end);
        }
    }
}

