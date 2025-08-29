import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int n;
    static int m;
    static int[] answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[n];
        answer = new int[m];
        Arrays.sort(arr);

        dfs(0);
    }

    public static void dfs(int depth){
        if(depth == m){
            for(int i = 0; i < m; i++)
                System.out.print(answer[i] + " ");
            System.out.println();
            return;
        }
        for(int i = 0; i < n; i++){

            if(!visited[i]){
                visited[i] = true;
                answer[depth] = arr[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}


