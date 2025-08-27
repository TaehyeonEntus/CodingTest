import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++) {
            rank[i] = 1;
        }
        for (int i = 0; i < n; i++)
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int a = 0; a < n; a++)
            for(int b = 0; b < n; b++){
                if(a==b)
                    continue;
                int currentW = arr[a][0];
                int currentH = arr[a][1];

                int targetW = arr[b][0];
                int targetH = arr[b][1];

                if(currentW < targetW && currentH < targetH)
                    rank[a]++;
            }

        for(int i : rank)
            System.out.print(i + " ");
    }
}
