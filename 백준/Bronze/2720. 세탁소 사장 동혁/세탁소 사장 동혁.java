import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int money = parseInt(br.readLine());
            System.out.print(money / 25 +" ");
            money %= 25;
            System.out.print(money / 10+" ");
            money %= 10;
            System.out.print(money / 5+" ");
            money %= 5;
            System.out.println(money);
        }
    }
}