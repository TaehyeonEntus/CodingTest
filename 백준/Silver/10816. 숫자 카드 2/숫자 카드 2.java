import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] line1 = br.readLine().split(" ");

        int m = Integer.parseInt(br.readLine());
        String[] line2 = br.readLine().split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (String str : line1)
            if (!map.containsKey(str))
                map.put(str, 1);
            else
                map.put(str, map.get(str) + 1);

        for (String str : line2)
            sb.append(map.getOrDefault(str, 0)).append(" ");

        System.out.println(sb);
    }
}
