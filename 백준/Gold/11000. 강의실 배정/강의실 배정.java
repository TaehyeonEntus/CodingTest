import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Clazz> pq = new PriorityQueue<>(Comparator.comparingInt(Clazz::getStart).thenComparingInt(Clazz::getEnd));
    static PriorityQueue<Integer> endPQ = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.add(new Clazz(arr[0], arr[1]));
        }

        while (!pq.isEmpty()) {
            Clazz clazz = pq.poll();
            if (!endPQ.isEmpty() && (endPQ.peek() <= clazz.getStart()))
                endPQ.poll();
            endPQ.add(clazz.end);
        }

        System.out.println(endPQ.size());
    }

    public static class Clazz {
        int start;
        int end;

        public Clazz(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}