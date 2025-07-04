import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0, x = 0, y = 0;
        String[] string;
        for(int i = 0; i < 9; i++) {
            string = br.readLine().split(" ");
            for(int j = 0; j < 9; j++) {
                if(parseInt(string[j]) > max) {
                    max = parseInt(string[j]);
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(max);
        System.out.println((x+1)+" "+(y+1));
    }
}