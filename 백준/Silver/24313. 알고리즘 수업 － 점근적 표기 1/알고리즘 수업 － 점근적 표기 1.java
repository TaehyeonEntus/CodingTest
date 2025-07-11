import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a1 = Integer.parseInt(s[0]);
        int a0 = Integer.parseInt(s[1]);

        int c = Integer.parseInt(br.readLine());

        int n0 = Integer.parseInt(br.readLine());

        int x = c-a1; //n계수
        if(a0==0){
            System.out.println(1);
        }
        else {
            if(x<0)
                System.out.println(0);
            else if(x*n0>=a0)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}