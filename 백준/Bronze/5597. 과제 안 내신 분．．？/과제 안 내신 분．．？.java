import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 28;
        TreeSet<Integer> tree = new TreeSet<>() {
        };

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            tree.add(num);
        }
        
        for (int i = 1; i <= 30; i++) {
            if(!tree.contains(i)){
                System.out.println(i);
            }
        }
    }
}