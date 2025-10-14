import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list = new ArrayList<>();
    static int[] dp = new int[200_001];

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int k = arr[1];
        for (int i = 0; i < n; i++)
            list.add(Integer.parseInt(br.readLine()));

        dp[0] = 1;

        //바깥 반복문이 중복 되지 말아야 할 컬렉션이여야함.
        //1+1+1+...+1 을 1+1+1+2+...+2 이런식으로 표현 가능하기 때문에
        //그리디하게 DP한다고 생각하면 될듯?
        //한번 만들어 놨던 판위에 층층이 쌓는다고 생각 하면 편하다.
        for (int coin : list)
            for (int i = coin; i <= k; i++)
                dp[i] += dp[i - coin];


        System.out.println(dp[k]);
    }
}


