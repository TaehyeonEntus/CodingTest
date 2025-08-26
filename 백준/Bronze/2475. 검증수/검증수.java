import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).map(number->number*number).sum()%10);
    }
}

