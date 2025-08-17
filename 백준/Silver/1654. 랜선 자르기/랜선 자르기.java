import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Long> list = new ArrayList<>();
        int n = arr[0];
        int k = arr[1];
        for (int i = 0; i < n; i++) {
            list.add(Long.parseLong(br.readLine()));
        }
        list.sort(Comparator.naturalOrder());
        long start = 1;
        long end = list.get(n - 1);

        long answer = 0;
        while(start <= end){
            long total = 0;
            long mid = (start + end)/2;
            for(long i : list)
                total += i/mid;

            //너무 잘게 잘랐을 경우
            if(total >= k){
                answer = mid;
                start = mid+1;
            }
            //너무 크게 잘랐을 경우
            else if(total < k){
                end = mid-1;
            }
        }

        System.out.println(answer);
    }
}
