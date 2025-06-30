import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        List<Character> list = new ArrayList<>();

        for(char c : string.toCharArray()) {
            list.add(c);
        }

        for(int i = 0; i<26; i++) {
            char c = (char) ('a' + i);
            if(list.contains(c)) {
                System.out.print(list.indexOf(c));
            } else {
                System.out.print("-1");
            }
            System.out.print(" ");
        }
    }
}
