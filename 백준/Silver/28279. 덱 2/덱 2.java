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
            int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int command = intArr[0];
            if (command == 1 || command == 2 || command == 5 || command == 6) {
                if (command == 1)
                    queue.addFirst(intArr[1]);
                else if (command == 2)
                    queue.addLast(intArr[1]);
                else if (command == 5)
                    sb.append(queue.size()).append("\n");
                else if (command == 6)
                    sb.append(queue.isEmpty() ? "1" : "0").append("\n");
                continue;
            }

            if(queue.isEmpty()){
                sb.append("-1").append("\n");
                continue;
            }

            if(command == 3)
                sb.append(queue.removeFirst()).append("\n");
            else if(command == 4)
                sb.append(queue.removeLast()).append("\n");
            else if(command == 7)
                sb.append(queue.peekFirst()).append("\n");
            else if(command == 8)
                sb.append(queue.peekLast()).append("\n");
        }

        System.out.println(sb);
    }
}
