import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        int max = first;
        int maxIndex = 1;
        for (int i = 0; i < 8; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a > max) {
                max = a;
                maxIndex = i+2;
            }
        }
        System.out.println(max);
        System.out.println(maxIndex);
    }
}