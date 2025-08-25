import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static BufferedReader br;
    static int[][] house;
    static int n;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        house = new int[n][n];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                house[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
                if(!visited[i][j] && house[i][j] == 1)
                    list.add(bfs(i, j));

        list.sort(Comparator.naturalOrder());
        System.out.println(list.size());
        for(int i : list)
            System.out.println(i);
    }

    public static int bfs(int x, int y){
        visited[x][y] = true;
        int count = 1;

        if(x>0 && !visited[x-1][y] && house[x-1][y] == 1)
            count += bfs(x-1, y);
        if(y>0 && !visited[x][y-1] && house[x][y-1] == 1)
            count += bfs(x, y-1);
        if(x<n-1 && !visited[x+1][y] && house[x+1][y] == 1)
            count += bfs(x+1, y);
        if(y<n-1 && !visited[x][y+1] && house[x][y+1] == 1)
            count += bfs(x, y+1);

        return count;
    }
}

