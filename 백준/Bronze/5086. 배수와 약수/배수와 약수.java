import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = " ";
        str = br.readLine();
        while (!str.equals("0 0")){
            String[] s = str.split(" ");
            int a = parseInt(s[0]);
            int b = parseInt(s[1]);

            if(a%b==0)
                System.out.println("multiple");
            else if(b%a==0)
                System.out.println("factor");
            else
                System.out.println("neither");
            str = br.readLine();
        }
    }
}