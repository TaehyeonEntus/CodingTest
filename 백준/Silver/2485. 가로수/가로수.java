import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        int prev = Integer.parseInt(br.readLine());
        int first = prev;
        int cur;
        for (int i = 1; i < n; i++) {
            cur = Integer.parseInt(br.readLine());
            set.add(cur - prev);
            prev = cur;
        }
        int last = prev;

        int prevNum = set.pollFirst().intValue();
        while (!set.isEmpty()) {
            int curNum = set.pollFirst();
            for(int j = prevNum; j > 0; j-- ){
                if((prevNum%j ==0)&&(curNum%j ==0)){
                    prevNum = j;
                    break;
                }
            }
        }
        int distance = prevNum;

        System.out.println((last-first)/distance-n+1);
    }
}
