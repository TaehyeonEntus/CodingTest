import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        dfs(n,m,0);
    }
    public static void dfs(int n, int m, int depth){
        if(depth == m) {
            queue.forEach(e -> System.out.print(e + " "));
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!queue.contains(i)){
                queue.add(i);
                dfs(n, m, depth+1);
                queue.removeLast();
            }
        }
    }
}

