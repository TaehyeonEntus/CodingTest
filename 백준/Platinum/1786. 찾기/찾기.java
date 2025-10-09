import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String t = br.readLine();
        String p = br.readLine();

        int[] z = zAlgorithm(p+"#"+t);

        for(int i = 0; i < z.length; i++){
            if(z[i] == p.length()) list.add(i - p.length());
        }
        System.out.println(list.size());
        for(int i : list) System.out.print(i + " ");
    }

    public static int[] zAlgorithm(String string) {
        int length = string.length();
        int[] z = new int[length];
        // Z Box 범위
        int left = 0, right = 0;
        for (int i = 1; i < length; i++) {

            // i가 Z Box 안에 있는 경우
            if (i <= right) {
                // 남은 박스 범위와 상대 인덱스 기준 값 중 작은 값으로 초기화
                // 작은 값으로 초기화 하는 이유는 K[i - left] 값이 Z Box 범위를 벗어날 수 있기 때문
                // 범위를 벗어난 경우 아래 있는 while문으로 추가 계산
                z[i] = Math.min(right - i + 1, z[i - left]);
            }

            //Z 박스 밖에 있는경우 (초기 또는 Z Box를 넘어가는경우)
            while (i + z[i] < length && string.charAt(z[i]) == string.charAt(i + z[i])) {
                z[i]++;
            }

            //Z Box 갱신
            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }
        }
        return z;
    }
}