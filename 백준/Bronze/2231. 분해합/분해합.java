import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i<n; i++){
            int number = i;
            int sum = number;
            while(number != 0){
                sum += number % 10;
                number /= 10;
            }
            if(sum == n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}