import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line == null) break;

            int n = Integer.parseInt(line);

            int target = 1%n;
            int count = 1;
            while (target != 0) {
                target = (target * 10 + 1)%n;
                count++;
            }
            System.out.println(count);
        }
    }
}
