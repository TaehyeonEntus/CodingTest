import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int total = 0;
        Set<String> set = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            String line = br.readLine();
            if(line.equals("ENTER")){
                total+=set.size();
                set.clear();
            }
            else
                set.add(line);
        }
        total+=set.size();

        System.out.println(total);
    }
}

