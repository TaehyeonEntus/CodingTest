import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        int n = (int)arr[0];
        long m = arr[1];

        arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        List<Long> list = new ArrayList<>();
        for (long i : arr)
            list.add(i);

        Collections.sort(list);
        long start = 1;
        long end = list.get(n - 1);

        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long total = 0;
            for (long i : list) {
                long tree = i-mid;
                if(tree>0)
                    total += tree;
            }
            if(total>=m) {
                start = mid + 1;
                answer = mid;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
