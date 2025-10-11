import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] roots;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t <T; t++) {
            int n = Integer.parseInt(br.readLine());
            roots = new int[n];

            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i = 0; i < n; i++)
                roots[i] = arr[i]-1;

            int count = 0;
            int[] isUnion = new int[n];
            for(int i = 0; i < n; i++) {
                if(isUnion[i] == 1){
                    count++;
                    continue;
                } else if(isUnion[i] == -1){
                    continue;
                }

                set.clear();
                set.add(i);
                int number = roots[i];
                while (!set.contains(number)) {
                    if(isUnion[number] == 1 || isUnion[number] == -1)
                        break;
                    set.add(number);
                    number = roots[number];
                }

                if(number == i) {
                    for (int num : set)
                        isUnion[num] = 1;
                    count++;
                }else{
                    isUnion[i] = -1;
                    int a = roots[i];
                    while (a!=number){
                        isUnion[a] = -1;
                        a = roots[a];
                    }
                }
            }
            sb.append(n-count).append("\n");
        }
        System.out.println(sb);
    }
}
