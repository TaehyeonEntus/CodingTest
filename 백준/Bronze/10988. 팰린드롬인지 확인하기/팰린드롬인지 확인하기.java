import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String reverseStr = sb.append(str).reverse().toString();
        System.out.println(reverseStr.equals(str) ? 1 : 0);
    }
}
