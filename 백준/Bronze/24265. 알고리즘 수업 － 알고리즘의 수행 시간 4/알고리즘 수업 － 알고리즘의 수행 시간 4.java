import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long total = 0;
        for(long i = 1; i < n; i++) {
            total+=i;
        }
        System.out.println(total);
        System.out.println(2);
    }
}