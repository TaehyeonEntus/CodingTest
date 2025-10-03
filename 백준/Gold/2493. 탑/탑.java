import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> stack = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        stack.push(0);
        sb.append(0).append(" ");

        for (int i = 1; i < n; i++) {
            //현재 값보다 작은 수는 다 제거
            while (!stack.isEmpty() && (arr[stack.peek()] < arr[i]))
                stack.pop();

            //수신 받는 탑이 없는 경우 (현재까지 가장 높은 탑인경우)
            if (stack.isEmpty())
                sb.append(0).append(" ");
            //수신 받는 탑이 있는 경우 (stack.peek()이 가장 가까운 탑의 인덱스, N번째 값을 넣어야 하기 때문에 +1)
            else
                sb.append(stack.peek() + 1).append(" ");

            stack.push(i);
        }
        System.out.println(sb);
    }
}
