import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x!=0)
                stack.push(x);
            else
                stack.pop();
        }
        int total = 0;
        for(Integer i : stack)
            total += i;
        System.out.println(total);
    }
}
