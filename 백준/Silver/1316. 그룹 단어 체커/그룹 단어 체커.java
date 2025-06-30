import java.io.*;
import java.security.Key;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < n; i++) {
            char beforeChar = '0';
            boolean isGroupWord = true;
            Set<Character> set = new HashSet<>();
            String str = br.readLine();
            for(char c : str.toCharArray()) {
                if(beforeChar == c) {
                    continue;
                }
                else {
                    if(set.contains(c)) {
                        isGroupWord = false;
                        break;
                    }
                    else {
                        beforeChar = c;
                        set.add(c);
                    }
                }
            }
            if(isGroupWord) {
                count++;
            }
        }
        System.out.println(count);
    }
}
