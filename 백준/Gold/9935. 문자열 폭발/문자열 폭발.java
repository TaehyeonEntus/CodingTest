import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Character> stack = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        String bomb = br.readLine();
        char endChar = bomb.charAt(bomb.length() - 1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c);
            if (c == endChar) {
                int start = sb.length()-bomb.length();
                int end = sb.length();

                if(start < 0)
                    continue;

                if(sb.substring(start, end).toString().equals(bomb))
                    sb.delete(start, end);
            }
        }

        if (sb.length() == 0)
            System.out.println("FRULA");
        else
            System.out.println(sb);
    }
}

