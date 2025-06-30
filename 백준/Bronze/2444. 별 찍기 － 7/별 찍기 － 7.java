import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            for(int j = n-1; j > i; j--) {
                System.out.print(" ");
            }
            System.out.print("*");
            for(int k = 0; k < i; k++) {
                System.out.print("**");
            }
            System.out.println();
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for(int k = n-1; k > i; k--) {
                System.out.print("**");
            }
            System.out.println();
        }
    }
}
