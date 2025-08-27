import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            queue.clear();
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = arr[0];
            int M = arr[1];

            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(queue::add);

            int currentIndex = M;
            int count = 0;

            while (!queue.isEmpty()){
                int maxP = Collections.max(queue);
                int target = queue.pollFirst();

                //인쇄
                if (target == maxP) {
                    count++;
                    if (currentIndex == 0) {
                        System.out.println(count);
                        break;
                    }
                }
                //제끼기
                else {
                    queue.addLast(target);
                }

                currentIndex--;
                if (currentIndex < 0) currentIndex = queue.size() - 1;
            }
        }
    }
}
