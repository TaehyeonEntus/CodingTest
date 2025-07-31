import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] s0 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] s1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int up = 0;
        int down = 0;

        up+= s0[0]*s1[1] + s0[1]*s1[0];
        down+= s0[1]*s1[1];

        int min = Math.min(up, down);
        for(int i = min; i > 1; i--) {
            if(up%i == 0 && down%i == 0){
                up/=i;
                down/=i;
                break;
            }
        }
        System.out.println(up+" "+down);
    }
}
