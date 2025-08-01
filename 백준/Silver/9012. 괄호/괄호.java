import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            boolean isVps = true;
            stack.clear();
            String line = br.readLine();
            for (char c : line.toCharArray()) {
                if(c == '(')
                    stack.push(i);
                else
                    try {
                        stack.pop();
                    } catch (EmptyStackException e) {
                        isVps = false;
                        break;
                    }
            }
            if(!stack.isEmpty())
                isVps = false;

            System.out.println(isVps?"YES":"NO");
        }
    }
}
