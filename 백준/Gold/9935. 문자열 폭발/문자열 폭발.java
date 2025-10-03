import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        String bomb = br.readLine();

        //bomb trigger
        char trigger = bomb.charAt(bomb.length() - 1);

        for (char c : s.toCharArray()) {
            sb.append(c);
            if (c == trigger) {
                int start = sb.length()-bomb.length();
                int end = sb.length();

                if(start < 0) continue;

                if(sb.substring(start, end).equals(bomb))
                    sb.delete(start, end);
            }
        }

        if (sb.isEmpty()) System.out.println("FRULA");
        else System.out.println(sb);
    }
}