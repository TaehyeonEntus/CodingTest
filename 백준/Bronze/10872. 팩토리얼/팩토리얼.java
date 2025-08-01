import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long answer = factorial(n);
        System.out.println(answer);
    }

    public static long factorial(long n) {
        return n <= 0 ? 1 : factorial(n - 1) * n;
    }
}

