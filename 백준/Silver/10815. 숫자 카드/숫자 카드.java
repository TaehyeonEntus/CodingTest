import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line1 = br.readLine().split(" ");

        int m = Integer.parseInt(br.readLine());
        String[] line2 = br.readLine().split(" ");

        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            tree.add(Integer.parseInt(line1[i]));
        }

        for (String s : line2) {
            if (tree.contains(Integer.parseInt(s)))
                System.out.print(1 + " ");
            else
                System.out.print(0 + " ");
        }
    }
}
