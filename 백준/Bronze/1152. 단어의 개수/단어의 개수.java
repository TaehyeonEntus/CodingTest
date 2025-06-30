import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        for(String s : br.readLine().trim().split(" ")){
            if(!s.isEmpty())
                list.add(s);
        }
        System.out.println(list.size());
    }
}
