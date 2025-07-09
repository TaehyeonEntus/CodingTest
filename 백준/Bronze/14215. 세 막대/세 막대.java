import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);

        int[] arr = {a,b,c};
        Arrays.sort(arr);
        if(arr[0]+arr[1] > arr[2])
            System.out.println(a+b+c);
        else
            System.out.println((arr[0]+arr[1])*2-1);
    }
}