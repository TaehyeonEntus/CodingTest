import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int command = Integer.parseInt(String.valueOf(line.charAt(0)));
            switch (command) {
                case 1:
                    String[] s = line.split(" ");
                    stack.push(Integer.parseInt(s[1]));
                    break;
                case 2:
                    if (stack.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(stack.pop());
                    break;
                case 3:
                    System.out.println(stack.size());
                    break;
                case 4:
                    if(stack.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case 5:
                    if (stack.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(stack.peek());
                    break;
            }
        }
    }
}
