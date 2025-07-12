import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);

        int d = Integer.parseInt(str[3]);
        int e = Integer.parseInt(str[4]);
        int f = Integer.parseInt(str[5]);

        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                int x = a * i + b * j - c;
                int y = d * i + e * j - f;
                if(x==0 && y==0) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }
}