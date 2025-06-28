import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n_m = br.readLine().split(" ");
        int n = Integer.parseInt(n_m[0]);
        int m = Integer.parseInt(n_m[1]);
        int[] basket = new int[n];

        for(int i = 0; i < m; i++) {
            String[] throwBall = br.readLine().split(" ");
            int startIndex = Integer.parseInt(throwBall[0]) - 1;
            int endIndex = Integer.parseInt(throwBall[1]) - 1;
            int ballNum = Integer.parseInt(throwBall[2]);
            for(int j = startIndex; j <= endIndex; j++) {
                basket[j]=ballNum;
            }
        }

        for(int a : basket){
            System.out.print(a+" ");
        }
    }
}