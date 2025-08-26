import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int i1 = Integer.parseInt(br.readLine());
        int i2 = Integer.parseInt(br.readLine());
        int i3 = Integer.parseInt(br.readLine());

        int answer = i1 * i2 * i3;
        String str = String.valueOf(answer);

        int[] arr = new int[10];
        for(char c : str.toCharArray()) {
            arr[Character.getNumericValue(c)]++;
        }

        for(int i : arr)
            System.out.println(i);
    }
}

