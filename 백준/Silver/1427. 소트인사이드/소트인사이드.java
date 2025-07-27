import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer i = Integer.valueOf(br.readLine());

        List<Integer> list = new ArrayList<>();
        while(i!=0){
            list.add(i%10);
            i/=10;
        }
        Collections.sort(list,Collections.reverseOrder());
        
        for(Integer a : list){
            System.out.print(a);
        }
    }
}