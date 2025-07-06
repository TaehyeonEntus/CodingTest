import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int b = Integer.parseInt(strArr[0]);
        int n = Integer.parseInt(strArr[1]);
        StringBuilder sb = new StringBuilder();

        while(b!=0){
            int a = b%n;
            if(a>=10)
                sb.append((char)(a+55));
            else
                sb.append(a);
            b /= n;
        }

        System.out.println(sb.reverse());
    }
}