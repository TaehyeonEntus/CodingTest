import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] str = br.readLine().split(" ");
        while (!str[0].equals("#")){
            if(Integer.parseInt(str[1])>=18 || Integer.parseInt(str[2])>= 80)
                System.out.println(str[0] + " Senior");
            else
                System.out.println(str[0] + " Junior");
            
            str = br.readLine().split(" ");
        }
    }
}