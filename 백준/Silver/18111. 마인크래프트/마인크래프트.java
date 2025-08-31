import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int n;
    static int m;
    static int inventory;
    static int maxHeight = 0;
    static int minHeight = Integer.MAX_VALUE;

    static int maxHeightCount;
    static int minHeightCount;

    static int time = 0;
    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        map = new int[n][m];
        inventory = arr[2];
        for(int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxHeight = Math.max(maxHeight, map[i][j]);
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }
        flat();
    }

    public static void flat(){
        while (maxHeight != minHeight){
            maxHeightCount = 0;
            minHeightCount = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == maxHeight)
                        maxHeightCount++;
                    if(map[i][j] == minHeight)
                        minHeightCount++;
                }
            }
            //minCount가 더 많음 (위에 깎는게 효율적) or 낮은곳 평탄화할 블럭이 충분하지 않음
            if((2*maxHeightCount<minHeightCount) || (inventory<minHeightCount))
                upFlat();
            else
                downFlat();

        }
        System.out.println(time+" "+maxHeight);
    }

    public static void upFlat(){
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(map[i][j] == maxHeight){
                    map[i][j]--;
                    time += 2;
                    inventory++;
                }
        maxHeight--;
    }

    public static void downFlat(){
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(map[i][j] == minHeight){
                    map[i][j]++;
                    time += 1;
                    inventory--;
                }
        minHeight++;
    }
}