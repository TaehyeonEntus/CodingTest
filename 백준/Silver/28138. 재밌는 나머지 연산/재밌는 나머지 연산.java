import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<Long> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long a = arr[0];
        long b = arr[1];

        long num = a-b;

        for (long i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i > b)
                    set.add(i);
                if ((num / i) > b)
                    set.add(num / i);
            }
        }

        long total = 0;
        for(long number : set)
            total += number;
        System.out.println(total);
    }
}