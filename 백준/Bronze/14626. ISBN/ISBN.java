import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int total = 0;
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split("");
        int index = 0;
        for(int i = 0; i<13; i++){
            if(s[i].equals("*")) {
                index = i;
                continue;
            }
            int number = Integer.parseInt(s[i]);
            if(i%2==0)
                total+=number;
            else
                total+=(3*number);
        }
        if(index%2==0)
            System.out.println(10-total%10);
        else
            for(int i = 0; i<10; i++)
                if((total+(3*i))%10==0){
                    System.out.println(i);
                    break;
                }
    }
}

