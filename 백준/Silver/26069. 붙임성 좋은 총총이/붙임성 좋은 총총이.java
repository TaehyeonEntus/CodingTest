import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        String chong = "ChongChong";
        set.add(chong);
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            if(set.contains(line[0])||set.contains(line[1])) {
                set.add(line[0]);
                set.add(line[1]);
            }
        }
        System.out.println(set.size());
    }
}

