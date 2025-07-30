import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);
        TreeSet<String> tree = new TreeSet<>();
        for(int i = 0; i<n; i++){
            tree.add(br.readLine());
        }
        
        int count = 0;
        for(int i = 0; i<m; i++)
            if(tree.contains(br.readLine()))
                count++;

        System.out.println(count);
    }
}
