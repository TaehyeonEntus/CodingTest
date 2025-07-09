import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] s = br.readLine().split(" ");
            int line1 = Integer.parseInt(s[0]);
            int line2 = Integer.parseInt(s[1]);
            int line3 = Integer.parseInt(s[2]);

            int max = Math.max(line1, line2);
            max = Math.max(max, line3);

            if(line1 == 0)
                break;

            if(line1+line2+line3 > max*2){
                if(line1 == line2 || line1 == line3 || line2 == line3){
                    if(line1 == line2 && line2 == line3)
                        System.out.println("Equilateral");
                    else
                        System.out.println("Isosceles");
                } else
                    System.out.println("Scalene");
            }
            else
                System.out.println("Invalid");
        }
    }
}