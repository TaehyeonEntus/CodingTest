import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Integer> list = new ArrayList<>();
        int avg = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            avg+=num;
            list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Collections.sort(list);
        int max = -4001;
        int min = 4001;

        Integer[] array = map.keySet().stream().sorted().toArray(Integer[]::new);
        for(Integer i : array){
            if(i > max) max = i;
            if(i < min) min = i;
        }

        int mid = list.get(n/2);
        avg = Math.round((float)avg / n);
        int range = max - min;

        Integer most = map.values().stream().max(Integer::compareTo).get();
        TreeSet<Integer> set = new TreeSet<>();
        for(Integer i : map.keySet()){
            if(map.get(i) == most)
                set.add(i);
        }

        if(set.size() >= 2)
            set.remove(set.first());
        Integer mostValue = set.first();

        System.out.println(avg);
        System.out.println(mid);
        System.out.println(mostValue);
        System.out.println(range);
    }
}

