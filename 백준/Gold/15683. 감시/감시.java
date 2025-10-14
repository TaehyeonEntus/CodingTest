import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static int n;
    static int m;
    static int min = Integer.MAX_VALUE;
    static List<CCTV> cctvs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++)
                if (map[i][j] >= 1 && map[i][j] <= 5)
                    cctvs.add(new CCTV(i, j, map[i][j]));
        }
        dfs(0,map);
        System.out.println(min);
    }

    public static void dfs(int depth, int[][] map) {
        if (depth == cctvs.size()) {
            min = Math.min(min, countSafeZone(map));
            return;
        }

        CCTV cctv = cctvs.get(depth);
        for (int i = 0; i < 4; i++) {
            if(cctv.number == 5 && i >=1)
                continue;
            else if(cctv.number == 2 && i>=2)
                continue;
            dfs(depth + 1, detect(map, cctv, i));
        }
    }

    public static class CCTV {
        int x;
        int y;
        int number;

        public CCTV(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }
    }

    static public int[][] detect(int[][] map, CCTV cctv, int dir) {
        int number = cctv.number;
        int[][] returnMap = new int[n][m];
        for(int i = 0; i < n; i++)
            if (m >= 0) System.arraycopy(map[i], 0, returnMap[i], 0, m);

        switch (number) {
            case 1:
                returnMap = check(returnMap, cctv.x, cctv.y, dir);
                break;
            case 2:
                returnMap = check(returnMap, cctv.x, cctv.y, dir);
                returnMap = check(returnMap, cctv.x, cctv.y, dir+2);
                break;
            case 3:
                returnMap = check(returnMap, cctv.x, cctv.y, dir);
                returnMap = check(returnMap, cctv.x, cctv.y, dir+1);
                break;
            case 4:
                returnMap = check(returnMap, cctv.x, cctv.y, dir-1);
                returnMap = check(returnMap, cctv.x, cctv.y, dir);
                returnMap = check(returnMap, cctv.x, cctv.y, dir+1);
                break;
            case 5:
                returnMap = check(returnMap, cctv.x, cctv.y, dir);
                returnMap = check(returnMap, cctv.x, cctv.y, dir+1);
                returnMap = check(returnMap, cctv.x, cctv.y, dir+2);
                returnMap = check(returnMap, cctv.x, cctv.y, dir+3);
                break;
        }
        return returnMap;
    }

    static public int[][] check(int[][] map, int x, int y, int dir) {
        switch (dir) {
            case 0:
            case 4: //위쪽
                for (int i = x - 1; i >= 0; i--) {
                    if (map[i][y] == 6)
                        break;
                    else
                        map[i][y] = -1;
                }
                break;
            case 1: //오른쪽
                for (int i = y + 1; i < m; i++) {
                    if (map[x][i] == 6)
                        break;
                    else
                        map[x][i] = -1;
                }
                break;
            case 2: //아래쪽
                for (int i = x + 1; i < n; i++) {
                    if (map[i][y] == 6)
                        break;
                    else
                        map[i][y] = -1;
                }
                break;
            case -1:
            case 3: //왼쪽
                for (int i = y - 1; i >= 0; i--) {
                    if (map[x][i] == 6)
                        break;
                    else
                        map[x][i] = -1;
                }
                break;
        }
        return map;
    }

    public static int countSafeZone(int[][] map) {
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (map[i][j] == 0)
                    count++;
        return count;
    }
}
