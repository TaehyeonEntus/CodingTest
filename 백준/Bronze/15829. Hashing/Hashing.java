import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static long number = 1;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long mod = 1234567891;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long total = 0;
        for (char c : str.toCharArray()) {
            long charNum = c - 'a' + 1;
            total += charNum * number;
            total %= mod;
            number = ((number%mod)*31)%mod;
        }
        System.out.println(total);
    }
}

