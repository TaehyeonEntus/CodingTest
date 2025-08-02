import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if(word.length()<m)
                continue;
            int value = map.getOrDefault(word, 0) + 1;
            map.put(word, value);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list,Comparator.naturalOrder());
        Collections.sort(list,Comparator.comparing(String::length).reversed());
        Collections.sort(list,Comparator.comparing(map::get).reversed());

        StringBuilder sb = new StringBuilder();
        for(String word : list)
            sb.append(word).append("\n");
        System.out.println(sb);
    }
}

