import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long total = 0;

        for (int i = 1; i <= n - 2; i++) {
            total+= (n - i - 1) * (n - i);
        }

        System.out.println(total/2);
        System.out.println(3);
    }
}