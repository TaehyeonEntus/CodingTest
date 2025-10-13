import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long min = arr[0];
        long max = arr[1];

        boolean[] visited = new boolean[(int) (max - min) + 1];

        for (int i = 2; i <= (int) Math.sqrt(max); i++) {
            long pow = (long) i * i;

            //pow를 step으로 생각하면 이해하기 쉽다.
            //start는 min이상인 pow의 배수 중 가장 작은수
            long start;
            if(min%pow == 0)
                start = min;
            else
                start = (min / pow + 1) * pow;

            for (long j = start; j <= max; j += pow) {
                visited[(int) (j - min)] = true;
            }
        }

        int count = 0;
        for(boolean visit : visited){
            if(!visit)
                count++;
        }
        System.out.println(count);
    }
}
