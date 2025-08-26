import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        System.out.println(Integer.parseInt(str1)+Integer.parseInt(str2)-Integer.parseInt(str3));
        System.out.println(Integer.parseInt(str1+str2)-Integer.parseInt(str3));
    }
}

