import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        String b = strArr[0];
        int n = Integer.parseInt(strArr[1]);
        int sum = 0;
        for(char c : b.toCharArray()){
            int i = Character.getNumericValue(c);
            sum *= n;
            sum += i;
        }

        System.out.println(sum);
    }
}