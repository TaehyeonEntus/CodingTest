import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> set = new TreeSet<>();
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            for(int j = i; j <= str.length(); j++) {
                set.add(str.substring(i, j));
            }
        }

        System.out.println(set.size()-1);
    }
}
