import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            if (line[0].equals("push")) {
                queue.add(Integer.valueOf(line[1]));
            } else if (line[0].equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(queue.poll()).append("\n");
            } else if (line[0].equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (line[0].equals("empty")) {
                if (queue.isEmpty())
                    sb.append("1").append("\n");
                else
                    sb.append("0").append("\n");
            } else if (line[0].equals("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(queue.peekFirst()).append("\n");
            } else if (line[0].equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(queue.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
