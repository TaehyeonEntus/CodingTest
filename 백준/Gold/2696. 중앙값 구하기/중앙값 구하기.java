import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> upPq = new PriorityQueue<>();//큰숫자
        PriorityQueue<Integer> downPq = new PriorityQueue<>(Comparator.reverseOrder());//작은숫자
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            upPq.clear();
            downPq.clear();

            int length = Integer.parseInt(br.readLine());

            int times = length / 10;
            int temp = length % 10;

            if (temp != 0)
                times++;

            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < times; j++)
                Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(list::add);

            System.out.println((length + 1) / 2);
            for (int j = 0; j < length; j++) {
                int num = list.get(j);

                if (downPq.isEmpty() || num <= downPq.peek()) {
                    downPq.add(num);
                } else {
                    upPq.add(num);
                }

                if (downPq.size() - upPq.size() == 2) {
                    upPq.add(downPq.poll());
                } else if (upPq.size() > downPq.size()) {
                    downPq.add(upPq.poll());
                }

                if (j % 2 == 0) {
                    System.out.print(downPq.peek() + " ");
                }
            }
            System.out.println();
        }
    }
}
