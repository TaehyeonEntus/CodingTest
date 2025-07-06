import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dot = 2;
        for(int i = 0; i < n; i++) {
            dot += (int) Math.pow(2, i);
        }
        System.out.println(dot*dot);
    }
}