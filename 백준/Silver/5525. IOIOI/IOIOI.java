import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int count = 0;
    static int left = 0;
    static int right = 2;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        String target = br.readLine();
        char[] chars = target.toCharArray();
        int total = 0;

        while (right < target.length()) {
            if (chars[left] != 'I') {
                left = left + 1;
                right = left + 2;
                continue;
            } else {
                //홀수면 O 짝수면 I
                if (chars[right] == 'I' && chars[right - 1] == 'O') {
                    total += 1;
                    right += 2;
                } else {
                    int temp = total - n + 1;
                    if(temp >= 1)
                        count+=temp;
                    left = right - 1;
                    right = left + 2;
                    total = 0;
                }
            }
        }
        int temp = total - n + 1;
        if(temp >= 1)
            count+=temp;

        System.out.println(count);
    }
}