import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Map<Integer, String> numberMap = new HashMap<>();
        Map<String, Integer> stringMap = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            numberMap.put(i+1, str);
            stringMap.put(str, i+1);
        }

        for(int i = 0; i < m; i++) {
            String temp = br.readLine();
            if(Character.isDigit(temp.charAt(0)))
                System.out.println(numberMap.get(Integer.parseInt(temp)));
            else
                System.out.println(stringMap.get(temp));
        }
    }
}
