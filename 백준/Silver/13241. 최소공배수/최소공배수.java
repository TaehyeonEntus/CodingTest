import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] s = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        for (long j = 1; j <= s[0] * s[1]; j++)
            if (((s[0] * j) % s[1]) == 0) {
                System.out.println(s[0] * j);
                break;
            }
        
    }
}
