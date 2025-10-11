import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++)
            pq.add(Integer.parseInt(br.readLine()));
        while (pq.size() >= 2) {
            int i1 = pq.poll();
            int i2 = pq.poll();

            pq.add(i1 + i2);
            sum += (i1 + i2);
        }
        System.out.println(sum);
    }
}
