import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> oldList = new ArrayList<>();

        String[] str = br.readLine().split(" ");

        for(String s : str){
            oldList.add(Integer.parseInt(s));
        }

        oldList.sort(Comparator.reverseOrder());
        int max = oldList.get(0);

        double total = 0;

        for(int a : oldList){
            total += (((double)a/(double)max)*100);
        }

        System.out.print(total/n);
    }
}