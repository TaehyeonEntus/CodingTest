import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int layer = 1;
        int maxRoomNumber = 1;
        while(true){
            if(n<=maxRoomNumber){
                System.out.println(layer);
                break;
            }
            maxRoomNumber += 6*layer++;
        }
    }
}