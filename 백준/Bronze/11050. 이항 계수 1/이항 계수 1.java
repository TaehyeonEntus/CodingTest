import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        System.out.println(process(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
    }

    public static int process(int n, int k) {
        if (k == 0 || k == n)
            return 1;

        return process(n - 1, k) + process(n - 1, k - 1);
    }
}

