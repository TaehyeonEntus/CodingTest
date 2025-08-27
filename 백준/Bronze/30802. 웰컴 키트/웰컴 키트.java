import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] sizes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] tp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int t = tp[0];
        int p = tp[1];

        int total = 0;
        for (int i : sizes) {
            int num = i / t;
            if (i % t == 0)
                total += num;
            else
                total += (num + 1);
        }
        System.out.println(total);
        System.out.println(n/p+" "+n%p);
    }
}

