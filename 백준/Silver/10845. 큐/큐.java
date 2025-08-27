import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> queue = new ArrayDeque<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] lines = br.readLine().split(" ");
            switch (lines[0]) {
                case "push":
                    queue.add(Integer.parseInt(lines[1]));
                    break;
                case "pop":
                    System.out.println(queue.isEmpty() ? "-1" : queue.pollFirst());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(queue.isEmpty() ? "-1" : queue.peekFirst());
                    break;
                case "back":
                    System.out.println(queue.isEmpty() ? "-1" : queue.peekLast());
                    break;
            }
        }
    }
}

