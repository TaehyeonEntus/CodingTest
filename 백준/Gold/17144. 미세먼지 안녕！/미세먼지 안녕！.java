import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] room;
    static int[][] sum;

    static int r;
    static int c;

    static int topMachineX;
    static int topMachineY;

    static int bottomMachineX;
    static int bottomMachineY;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        r = arr[0];
        c = arr[1];
        int t = arr[2];

        room = new int[r][c];
        sum = new int[r][c];
        for (int i = 0; i < r; i++) {
            room[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int targetX = 0;
        int targetY = 0;
        for (int i = 0; i < r; i++) {
            boolean find = false;
            for (int j = 0; j < c; j++)
                if (room[i][j] == -1) {
                    targetX = i;
                    targetY = j;
                    find = true;
                    break;
                }
            if (find)
                break;
        }

        //0~topMachineX, 0~c
        topMachineX = targetX;
        topMachineY = targetY;

        //bottomMachineX~r, 0~c
        bottomMachineX = targetX + 1;
        bottomMachineY = targetY;

        for(int i = 0; i<t;i++) {
            solve();
        }

        int total = 0;
        for(int[] roomArr : room)
            for(int dust : roomArr)
                total += dust!=-1?dust:0;

        System.out.println(total);
    }

    public static void solve() {
        for (int[] sumArr : sum)
            Arrays.fill(sumArr, 0);

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (room[i][j] != -1) {
                    int target = room[i][j];
                    int spread = target / 5;
                    if (i > 0 && room[i - 1][j] != -1) {
                        sum[i - 1][j] += spread;
                        sum[i][j] -= spread;
                    }

                    if (i < r - 1 && room[i + 1][j] != -1) {
                        sum[i + 1][j] += spread;
                        sum[i][j] -= spread;
                    }

                    if (j > 0 && room[i][j - 1] != -1) {
                        sum[i][j - 1] += spread;
                        sum[i][j] -= spread;
                    }

                    if (j < c - 1 && room[i][j + 1] != -1) {
                        sum[i][j + 1] += spread;
                        sum[i][j] -= spread;
                    }
                }


        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                room[i][j] += sum[i][j];

        //위쪽 순환
        for (int i = topMachineX - 1; i > 0; i--)
            room[i][0] = room[i - 1][0];
        for (int j = 0; j < c - 1; j++)
            room[0][j] = room[0][j + 1];
        for (int i = 0; i < topMachineX; i++)
            room[i][c - 1] = room[i + 1][c - 1];
        for (int j = c - 1; j > 1; j--)
            room[topMachineX][j] = room[topMachineX][j - 1];
        room[topMachineX][1] = 0;

        for (int i = bottomMachineX + 1; i < r - 1; i++)
            room[i][0] = room[i + 1][0];
        for (int i = 0; i < c - 1; i++)
            room[r - 1][i] = room[r - 1][i + 1];
        for (int i = r - 1; i > bottomMachineX; i--)
            room[i][c - 1] = room[i - 1][c - 1];
        for (int i = c - 1; i > 1; i--)
            room[bottomMachineX][i] = room[bottomMachineX][i - 1];
        room[bottomMachineX][1] = 0;
    }
}

