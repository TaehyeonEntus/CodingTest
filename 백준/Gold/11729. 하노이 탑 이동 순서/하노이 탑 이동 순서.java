import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println((int) Math.pow(2, n) - 1);
        hanoi(n, 1, 2, 3);
        System.out.println(sb);
    }

    public static void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
        } else {
            hanoi(n - 1, start, end, mid);
            sb.append(start).append(" ").append(end).append("\n");
            hanoi(n - 1, mid, start, end);
        }
    }
}

