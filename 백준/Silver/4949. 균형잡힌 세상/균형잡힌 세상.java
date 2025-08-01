import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        while (!line.equals(".")) {
            boolean isBalanced = true;
            stack.clear();
            for (char c : line.toCharArray()) {
                if (c == '(' || c == '[')
                    stack.push(c);
                else if (c == ')' || c == ']') {
                    if (stack.isEmpty()) {
                        isBalanced = false;
                        break;
                    }
                    if (stack.peek() == '(' && c == ')')
                        stack.pop();
                    else if (stack.peek() == '[' && c == ']')
                        stack.pop();
                    else {
                        isBalanced = false;
                        break;
                    }
                }
            }
            if (!stack.isEmpty())
                isBalanced = false;
            System.out.println(isBalanced ? "yes" : "no");
            line = br.readLine();
        }
    }
}
