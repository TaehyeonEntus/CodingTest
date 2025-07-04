import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = new String[5];
        for(int i = 0; i<5; i++){
            strArr[i] = br.readLine();
        }
        for(int i = 0; i<15; i++){

            for(int j = 0; j<5; j++){
                String str = strArr[j];
                if(i < str.length()){
                    System.out.print(str.charAt(i));
                }
            }
        }
    }
}