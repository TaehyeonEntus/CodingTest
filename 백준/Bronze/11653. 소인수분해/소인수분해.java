import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int i = 2;
        while (n != 1) {
            if(n % i == 0) {
                System.out.println(i);
                n /= i;
                continue;
            }
            i++;
        }
    }
}