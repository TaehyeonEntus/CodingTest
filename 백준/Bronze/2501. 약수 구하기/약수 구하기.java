import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = parseInt(s[0]);
        int b = parseInt(s[1]);
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<=a; i++){
            if(a%i==0)
                list.add(i);
        }
        if(list.size()>=b){
            System.out.println(list.get(b-1));
        } else
            System.out.println("0");
    }
}