import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String[] s = str1.split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int i = Integer.parseInt(st.nextToken());
            if(i < x) {
                System.out.print(i+" ");
            }
        }
    }
}