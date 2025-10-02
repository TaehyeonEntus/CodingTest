import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static char[][] map;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];

        map = new char[n][m];
        for (int i = 0; i < n; i++)
            map[i] = br.readLine().toCharArray();

        dfs(0, map);

        System.out.println(min==Integer.MAX_VALUE?-1:min);
    }

    public static void dfs(int depth, char[][] map) {
        if (depth == 11)
            return;

        if (depth > min)
            return;

        int r_x = -1;
        int r_y = -1;

        int b_x = -1;
        int b_y = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'R') {
                    r_x = i;
                    r_y = j;
                }
                if (map[i][j] == 'B') {
                    b_x = i;
                    b_y = j;
                }
            }
        }

        if (b_x == -1)
            return;

        if (r_x == -1) {
            min = depth;
            return;
        }

        int left_r_y = r_y;
        int right_r_y = r_y;
        int up_r_x = r_x;
        int down_r_x = r_x;

        int left_b_y = b_y;
        int right_b_y = b_y;
        int up_b_x = b_x;
        int down_b_x = b_x;

        boolean left_r_in = false;
        boolean right_r_in = false;
        boolean up_r_in = false;
        boolean down_r_in = false;

        boolean left_b_in = false;
        boolean right_b_in = false;
        boolean up_b_in = false;
        boolean down_b_in = false;

        for (int i = r_y; i >= 0; i--) {
            char c = map[r_x][i];
            if (c == 'O') {
                left_r_in = true;
                break;
            } else if (c == '#') {
                left_r_y = i + 1;
                break;
            }
        }

        for (int i = b_y; i >= 0; i--) {
            char c = map[b_x][i];
            if (c == 'O') {
                left_b_in = true;
                break;
            } else if (c == '#') {
                left_b_y = i + 1;
                break;
            }
        }

        for (int i = r_y; i < m; i++) {
            char c = map[r_x][i];
            if (c == 'O') {
                right_r_in = true;
                break;
            } else if (c == '#') {
                right_r_y = i - 1;
                break;
            }
        }

        for (int i = b_y; i < m; i++) {
            char c = map[b_x][i];
            if (c == 'O') {
                right_b_in = true;
                break;
            } else if (c == '#') {
                right_b_y = i - 1;
                break;
            }
        }

        for (int i = r_x; i >= 0; i--) {
            char c = map[i][r_y];
            if (c == 'O') {
                up_r_in = true;
                break;
            } else if (c == '#') {
                up_r_x = i + 1;
                break;
            }
        }

        for (int i = b_x; i >= 0; i--) {
            char c = map[i][b_y];
            if (c == 'O') {
                up_b_in = true;
                break;
            } else if (c == '#') {
                up_b_x = i + 1;
                break;
            }
        }

        for (int i = r_x; i < n; i++) {
            char c = map[i][r_y];
            if (c == 'O') {
                down_r_in = true;
                break;
            } else if (c == '#') {
                down_r_x = i - 1;
                break;
            }
        }

        for (int i = b_x; i < n; i++) {
            char c = map[i][b_y];
            if (c == 'O') {
                down_b_in = true;
                break;
            } else if (c == '#') {
                down_b_x = i - 1;
                break;
            }
        }



        char[][] leftMap = new char[n][m];
        char[][] rightMap = new char[n][m];
        char[][] upMap = new char[n][m];
        char[][] downMap = new char[n][m];

        for(int i = 0; i<n; i++) {
            leftMap[i] = map[i].clone();
            rightMap[i] = map[i].clone();
            upMap[i] = map[i].clone();
            downMap[i] = map[i].clone();
        }

        leftMap[r_x][r_y] = '.';
        rightMap[r_x][r_y] = '.';
        upMap[r_x][r_y] = '.';
        downMap[r_x][r_y] = '.';

        leftMap[b_x][b_y] = '.';
        rightMap[b_x][b_y] = '.';
        upMap[b_x][b_y] = '.';
        downMap[b_x][b_y] = '.';

        if (!left_r_in)
            leftMap[r_x][left_r_y] = 'R';
        if (!right_r_in)
            rightMap[r_x][right_r_y] = 'R';
        if (!up_r_in)
            upMap[up_r_x][r_y] = 'R';
        if (!down_r_in)
            downMap[down_r_x][r_y] = 'R';

        if (!left_b_in)
            leftMap[b_x][left_b_y] = 'B';
        if (!right_b_in)
            rightMap[b_x][right_b_y] = 'B';
        if (!up_b_in)
            upMap[up_b_x][b_y] = 'B';
        if (!down_b_in)
            downMap[down_b_x][b_y] = 'B';

        if(!left_r_in && !left_b_in && (b_x == r_x) && (left_b_y==left_r_y)){
            if(b_y > r_y){
                leftMap[r_x][left_r_y] = 'R';
                leftMap[b_x][left_r_y+1] = 'B';
            }else {
                leftMap[r_x][left_r_y] = 'B';
                leftMap[b_x][left_r_y+1] = 'R';
            }
        }
        if(!right_r_in && !right_b_in && (b_x == r_x) && (right_b_y==right_r_y)){
            if(b_y > r_y){
                rightMap[r_x][right_b_y] = 'B';
                rightMap[b_x][right_b_y-1] = 'R';
            }else {
                rightMap[r_x][right_b_y] = 'R';
                rightMap[b_x][right_b_y-1] = 'B';
            }
        }
        if(!up_r_in && !up_b_in && (b_y == r_y) && (up_b_x==up_r_x)){
            if(b_x < r_x){
                upMap[up_r_x][r_y] = 'B';
                upMap[up_r_x+1][r_y] = 'R';
            }else{
                upMap[up_r_x][r_y] = 'R';
                upMap[up_r_x+1][r_y] = 'B';
            }
        }
        if(!down_r_in && !down_b_in && (b_y == r_y) && (down_b_x==down_r_x)){
            if(b_x < r_x){
                downMap[down_r_x][r_y] = 'R';
                downMap[down_r_x-1][r_y] = 'B';
            }else {
                downMap[down_r_x][r_y] = 'B';
                downMap[down_r_x-1][r_y] = 'R';
            }
        }

        if(!left_b_in && !(leftMap[b_x][b_y] == 'B' && leftMap[r_x][r_y] == 'R'))
            dfs(depth + 1, leftMap);
        if(!right_b_in && !(rightMap[b_x][b_y] == 'B' && rightMap[r_x][r_y] == 'R'))
            dfs(depth + 1, rightMap);
        if(!up_b_in && !(upMap[b_x][b_y] == 'B' && upMap[r_x][r_y] == 'R'))
            dfs(depth + 1, upMap);
        if(!down_b_in && !(downMap[b_x][b_y] == 'B' && downMap[r_x][r_y] == 'R'))
            dfs(depth + 1, downMap);
    }
}

