import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++)
            Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .forEach(pq::add);

        for (int i = 0; i < n - 1; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}
