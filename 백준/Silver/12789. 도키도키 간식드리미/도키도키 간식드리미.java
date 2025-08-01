import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = intArr.length - 1; i >= 0; i--) {
            stackA.push(intArr[i]);
        }

        while (true) {
            if(!stackA.isEmpty())
            if (stackA.peek() == count) {
                stackA.pop();
                count++;
                continue;
            }

            if(!stackB.isEmpty())
            if (stackB.peek() == count) {
                stackB.pop();
                count++;
                continue;
            }

            if (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
                continue;
            }

            if (stackA.isEmpty() && stackB.isEmpty()) {
                System.out.println("Nice");
                break;
            } else {
                System.out.println("Sad");
                break;
            }
        }
    }
}
