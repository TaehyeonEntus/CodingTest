import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && (arr[i] > arr[stack.peek()]))
                arr[stack.pop()] = arr[i];
            stack.push(i);
        }

        while (!stack.isEmpty())
            arr[stack.pop()] = -1;

        for (int i : arr)
            sb.append(i).append(" ");

        System.out.println(sb);
    }
}