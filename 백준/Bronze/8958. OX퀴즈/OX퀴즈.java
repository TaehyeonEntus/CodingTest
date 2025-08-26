import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int total = 0;
            int count = 1;
            String line = br.readLine();
            for(char c : line.toCharArray()) {
                if(c == 'O')
                    total += count++;
                else
                    count = 1;

            }
            System.out.println(total);
        }
    }
}

