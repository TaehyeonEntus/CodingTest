import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int targetIndex = 0;

        String line1 = br.readLine();
        if(Character.isDigit(line1.charAt(0))) {
            targetIndex = Integer.parseInt(line1)+3;
        }

        String line2 = br.readLine();
        if(Character.isDigit(line2.charAt(0))) {
            targetIndex = Integer.parseInt(line2)+2;
        }

        String line3 = br.readLine();
        if(Character.isDigit(line3.charAt(0))) {
            targetIndex = Integer.parseInt(line3)+1;
        }

        if(targetIndex%3==0){
            if(targetIndex%5==0)
                System.out.println("FizzBuzz");
            else
                System.out.println("Fizz");
        }
        else {
            if(targetIndex%5==0)
                System.out.println("Buzz");
            else
                System.out.println(targetIndex);
        }

    }
}

