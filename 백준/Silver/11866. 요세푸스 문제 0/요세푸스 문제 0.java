import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = intArr[0];
        int k = intArr[1];
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }
        System.out.print("<");
        while (true){
            if(queue.size()==1){
                System.out.println(queue.poll()+">");
                break;
            }

            for(int i = 0; i<k-1; i++)
                queue.add(queue.poll());

            System.out.print(queue.poll()+", ");
        }
    }
}
