import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for(int j = 0; j < i; j++) {
            String string = br.readLine();
            if(list.contains(string))
                continue;
            list.add(string);
        }

        list.sort(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));

        for(String s : list) {
            System.out.println(s);
        }
    }
}
