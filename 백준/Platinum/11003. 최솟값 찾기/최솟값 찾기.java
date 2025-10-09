import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int l;

    static Deque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        l = arr[1];

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            if (q.isEmpty()) {
                q.add(i);
            } else {
                while (!q.isEmpty() && (arr[q.peekLast()] >= arr[i]))
                    q.pollLast();
                q.add(i);
            }

            if ((i - q.peek()) >= l)
                q.poll();

            sb.append(arr[q.peek()]).append(" ");
        }
        System.out.println(sb);
    }
}