import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        Deque<Balloon> queue = new ArrayDeque<>();
        for (int step : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
            queue.add(new Balloon(count++, step));
        }

        Balloon balloon  = queue.poll();
        System.out.println(balloon.number);
        while (!queue.isEmpty()) {
            if(queue.isEmpty())
                break;

            if (balloon.step > 0) {
                for (int i = 0; i < balloon.step - 1; i++)
                    queue.addLast(queue.pollFirst());
                balloon = queue.pollFirst();
            }
            else {
                for (int i = 0; i < Math.abs(balloon.step) - 1; i++)
                    queue.addFirst(queue.pollLast());
                balloon = queue.pollLast();
            }
            System.out.println(balloon.number);
        }
    }

    public static class Balloon {
        int number;
        int step;

        public Balloon(int number, int step) {
            this.number = number;
            this.step = step;
        }
    }
}

