import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);

            for(int j = 0; j < s[1].length(); j++) {
                for(int k = 0; k < n; k++) {
                    System.out.print(s[1].charAt(j));
                }
            }
            System.out.println();
        }
    }
}
