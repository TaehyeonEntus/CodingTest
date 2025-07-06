import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int max = 1;
        int layer = 1;
        int x = 0;
        int y = 0;
        while (true) {
            if (n <= max) {
                int sum = layer+1;
                int step = n - (max - layer);
                if(layer % 2 == 0) {
                    x = step;
                    y = sum-step;
                } else {
                    x = sum-step;
                    y = step;
                }
                System.out.println(x+"/"+y);
                break;
            }
            max += ++layer;
        }
    }
}