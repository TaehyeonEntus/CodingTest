import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> set = new HashSet<>();
    static Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int zero = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == 0)
                zero++;
            else
                map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            for (int j = i + 1; j < n; j++)
                if (arr[i] != 0 && arr[j] != 0)
                    set.add(arr[i] + arr[j]);
        }

        if(zero >= 1){
            if(zero >= 3)
                set.add(0);
            for(int key : map.keySet()){
                if(map.get(key)>=2)
                    set.add(key);
            }
        }

        int count = 0;
        for(int number : arr)
            if(set.contains(number))
                count++;
        System.out.println(count);
    }
}
