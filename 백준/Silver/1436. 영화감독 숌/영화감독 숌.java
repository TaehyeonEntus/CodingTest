import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num = 666;
        int count = 0;
        while(true){
            String s = String.valueOf(num);
            if(s.contains("666"))
                count++;

            if(count == n){
                System.out.println(num);
                return;
            }
            num++;
        }
    }
}