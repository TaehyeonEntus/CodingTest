import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int min = 9999;
        for(int i = 0; i <= 1000; i++) {
            for(int j = 0; j <= 1666; j++) {
                if((5*i + 3*j)==n)
                    min = Math.min(min, i+j);
            }
        }

        int answer = min==9999?-1:min;
        System.out.println(answer);
    }
}