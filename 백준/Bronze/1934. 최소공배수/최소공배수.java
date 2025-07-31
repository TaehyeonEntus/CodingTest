import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 1; j <= s[0]*s[1]; j++)
                if(((s[0]*j)%s[1])==0) {
                    System.out.println(s[0]*j);
                    break;
                }
        }
    }
}
