import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<String> tree = new TreeSet<>(Comparator.reverseOrder());
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            if (s[1].equals("enter"))
                tree.add(s[0]);
            else
                tree.remove(s[0]);
        }

        for(String s : tree)
            System.out.println(s);
    }
}
