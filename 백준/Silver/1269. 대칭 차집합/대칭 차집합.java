import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        TreeSet<String> aSet = new TreeSet<>();
        TreeSet<String> bSet = new TreeSet<>();

        aSet.addAll(Arrays.asList(br.readLine().split(" ")));
        bSet.addAll(Arrays.asList(br.readLine().split(" ")));
        int total = aSet.size()+bSet.size();
        for(String s : aSet)
            if(bSet.contains(s))
                total-=2;
            

        System.out.println(total);
    }
}
