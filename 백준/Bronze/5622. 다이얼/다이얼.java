import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int total = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isLowerThan(c, 'C')) {
                total += 3;
            } else if (isLowerThan(c, 'F')) {
                total += 4;
            } else if (isLowerThan(c, 'I')) {
                total += 5;
            } else if (isLowerThan(c, 'L')) {
                total += 6;
            } else if (isLowerThan(c, 'O')) {
                total += 7;
            } else if (isLowerThan(c, 'S')) {
                total += 8;
            } else if (isLowerThan(c, 'V')) {
                total += 9;
            } else if (isLowerThan(c, 'Z')) {
                total += 10;
            }
        }
        System.out.println(total);
    }

    static boolean isLowerThan(char a, char b) {
        return a <= b;
    }
}
