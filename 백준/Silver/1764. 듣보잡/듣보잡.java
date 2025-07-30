import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        TreeSet<String> tree = new TreeSet<>();
        TreeSet<String> answer = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            tree.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (tree.contains(s))
                answer.add(s);
        }

        System.out.println(answer.size());
        for(String s : answer)
            System.out.println(s);
    }
}
