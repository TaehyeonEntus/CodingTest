import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String string = br.readLine();
            System.out.print(string.charAt(0));
            System.out.print(string.charAt(string.length()-1));
            System.out.println();
        }
    }
}
