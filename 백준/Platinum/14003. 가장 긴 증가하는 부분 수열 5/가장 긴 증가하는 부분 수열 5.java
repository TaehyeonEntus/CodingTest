import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> stack = new ArrayDeque<>();
    static List<Integer> lis = new ArrayList<>();
    static int[] index;

    //기본적인 LIS, 하지만 마지막 원소를 기록할 수 있는 index 배열을 추가...
    //index 배열을 뒤에서 greedy하게 탐색하면서 복원
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        index = new int[n];
        for (int i = 0; i < n; i++) {
            int value = arr[i];
            if (lis.isEmpty() || lis.get(lis.size() - 1) < value) {
                lis.add(value);
                index[i] = lis.size() - 1;
            } else {
                int idx = Collections.binarySearch(lis, value);

                if (idx < 0)
                    idx = -(idx + 1);

                index[i] = idx;

                lis.set(idx, value);
            }
        }

        int count = lis.size()-1;
        for (int i = n - 1; i >= 0; i--) {
            if (index[i] == count) {
                stack.push(arr[i]);
                count--;
            }
        }

        System.out.println(lis.size());
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}