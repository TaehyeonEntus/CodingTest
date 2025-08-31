import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] fruits;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        fruits = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        solve();

        System.out.println(max);
    }


    static int left = 0;
    static int right = 0;

    //슬라이딩 윈도우로 구현.... left 증가를 while로 묶으니까 시간복잡도가 해결됐음. 이전에 구현했던거는 copyOfRange해서 3종류 이상인지 검사하고 이상이면 left++, 시간복잡도 이슈 발생했음
    public static void solve() {
        int[] count = new int[10];
        int different = 0;
        while (right < n) {
            int fruit = fruits[right];
            if (count[fruit]++ == 0) {
                different++;
            }

            while (different > 2) {
                if (--count[fruits[left]] == 0)
                    different--;
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }
    }
}