import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        while (!str.equals("0")){
            sb.setLength(0);
            String reversed = sb.append(str).reverse().toString();
            if(reversed.equals(str))
                System.out.println("yes");
            else
                System.out.println("no");
            str = br.readLine();
        }
    }
}

