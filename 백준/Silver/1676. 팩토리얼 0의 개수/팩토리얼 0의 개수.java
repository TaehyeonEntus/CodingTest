import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        factorialProcess(n);
        System.out.println(count);
    }

    //10은 2*5인데 2는 충분히 많으니까 5의 개수 = 0의 개수
    static void factorialProcess(int n) {
        for (int i = 5; i <= n; i *= 5) {
            count += n / i;
        }
    }
}
