import java.io.*;
import java.security.Key;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else
                map.put(c, 1);
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        Collection<Integer> values = map.values();
        int max = Collections.max(values);
        int count = 0;
        Character c = null;
        for (Map.Entry<Character, Integer> entry : entries) {
            if(entry.getValue() == max){
                c = entry.getKey();
                count++;
            }
        }
        if(count >= 2)
            System.out.println("?");
        else
            System.out.println(c);
    }
}
