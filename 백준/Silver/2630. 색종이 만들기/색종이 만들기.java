import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(devideWhite(0,0,n));
        System.out.println(devideBlue(0,0,n));
    }

    static int devideBlue(int x, int y, int n) {
        boolean isBlue = true;
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (paper[i][j] == 0) {
                    isBlue = false;
                    break;
                }
            }
            if(!isBlue)
                break;
        }

        if(!isBlue){
            if(n==1)
                return 0;
            return devideBlue(x,y,n/2) + devideBlue(x+n/2,y,n/2) + devideBlue(x,y+n/2,n/2) + devideBlue(x+n/2,y+n/2,n/2);
        }
        return 1;
    }

    static int devideWhite(int x, int y, int n) {
        boolean isWhite = true;
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (paper[i][j] == 1) {
                    isWhite = false;
                    break;
                }
            }
            if(!isWhite)
                break;
        }

        if(!isWhite){
            if(n==1)
                return 0;
            return devideWhite(x,y,n/2) + devideWhite(x+n/2,y,n/2) + devideWhite(x,y+n/2,n/2) + devideWhite(x+n/2,y+n/2,n/2);
        }

        return 1;
    }


}
