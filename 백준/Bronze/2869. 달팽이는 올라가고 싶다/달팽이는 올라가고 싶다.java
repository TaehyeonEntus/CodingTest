import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int a = parseInt(strArr[0]);
        int b = parseInt(strArr[1]);
        int up = a - b;
        int v = parseInt(strArr[2]);
        int days = 0;
        if(a == v)
            days = 1;
        else{
            if((v-a)/up == 0){
                days = 2;
            }
            else {
                if((v-a)%up != 0){
                    days = (v-a)/up+2;
                }
                else {
                    days = (v-a)/up + 1;
                }
            }
        }

        System.out.println(days);
    }
}