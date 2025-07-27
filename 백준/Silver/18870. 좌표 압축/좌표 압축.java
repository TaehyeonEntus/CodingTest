import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int i = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] arr = new int[i];


        for(int j = 0; j < i; j++){
            arr[j] = Integer.parseInt(line[j]);
        }

        Set<Integer> set = new HashSet<>();
        for(int a : arr) {
            set.add(a);
        }
        List<Integer> list = new ArrayList<>(set);

        Collections.sort(list);

        Map<Integer, Integer> dictionary = new HashMap<>();
        for (int index = 0; index < list.size(); index++) {
            dictionary.put(list.get(index), index);
        }

        for(int a : arr){
            sb.append(dictionary.get(a) + " ");
        }

        System.out.println(sb);
    }
}
