import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int k;
    static boolean[] visited;
    static String[] strArr;
    static List<String> strList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        strArr = new String[n];
        for(int i = 0; i < n; i++) {
            strArr[i] = br.readLine();
        }
        k = Integer.parseInt(br.readLine());
        visited = new boolean[n];

        dfs(0,"");
        int total = 0;
        for(String s : strList){
            int temp = 0;
            for(int i = 0; i<s.length(); i++){
                String start = s.substring(i);
                String end = s.substring(0, i);
                String str = start+end;
                if(s.equals(str))
                    temp++;
                if(temp > k)
                    break;
            }
            if(temp == k)
                total++;
        }
        System.out.println(total);
    }

    static void dfs(int depth, String str) {
        if (depth == n) {
            strList.add(str);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, str + strArr[i]);
                visited[i] = false;
            }
        }
    }
}

