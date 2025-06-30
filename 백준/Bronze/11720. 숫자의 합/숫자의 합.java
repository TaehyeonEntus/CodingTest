import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        char[] charArray = br.readLine().toCharArray();
        int total = 0;

        for (int i = 0; i < t; i++) {
            total += Character.getNumericValue(charArray[i]);
        }

        System.out.println(total);
    }
}
