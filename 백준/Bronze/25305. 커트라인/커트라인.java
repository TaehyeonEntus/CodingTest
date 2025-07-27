import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        ArrayList<Integer> list = new ArrayList<>();
        String[] a = br.readLine().split(" ");

        for(String str : a) {
            list.add(Integer.parseInt(str));
        }


        list.sort(Collections.reverseOrder());

        System.out.println(list.get(k-1));
    }
}