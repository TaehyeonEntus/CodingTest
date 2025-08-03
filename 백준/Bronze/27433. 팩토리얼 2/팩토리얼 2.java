import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        System.out.println(factorial(n));
    }
    public static long factorial(long n) {
        return n <= 1 ? 1 : n * factorial(n - 1);
    }
}

