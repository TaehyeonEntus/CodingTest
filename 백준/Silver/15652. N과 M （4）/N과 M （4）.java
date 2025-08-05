import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        dfs(n, m, 0);

        System.out.println(sb);
    }

    public static void dfs(int n, int m, int depth) {
        if (depth == m) {
            queue.forEach(e -> sb.append(e).append(" "));
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (queue.isEmpty())
                queue.add(i);
            else if (queue.peekLast() <= i)
                queue.add(i);
            else
                continue;
            dfs(n, m, depth + 1);
            queue.removeLast();
        }
    }
}

