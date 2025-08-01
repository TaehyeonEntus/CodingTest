import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] isQueue = br.readLine().split(" ");
        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = n-1; i >= 0; i--)
            if ("0".equals(isQueue[i]))
                deque.add(init[i]);

        int b = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < b; i++) {
            int answer = input[i];
            deque.add(answer);
            sb.append(deque.poll()).append(" ");
        }
        System.out.println(sb);
    }
}

