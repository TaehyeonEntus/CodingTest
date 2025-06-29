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

        for (int i = 0; i < n; i++) {
            basket[i] = i+1;
        }

        for(int i = 0; i < m; i++) {
            String[] basketNum = br.readLine().split(" ");
            int basketA = Integer.parseInt(basketNum[0])-1;
            int basketB = Integer.parseInt(basketNum[1])-1;

            int temp = basket[basketA];
            basket[basketA] = basket[basketB];
            basket[basketB] = temp;
        }

        for(int a : basket){
            System.out.print(a+" ");
        }
    }
}