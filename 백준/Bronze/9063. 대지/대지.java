import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int minX = 10000;
        int minY = 10000;
        int maxX = -10000;
        int maxY = -10000;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }
        if (minX == maxX || minY == maxY)
            System.out.println(0);
        else
            System.out.println((maxX - minX)*(maxY - minY));
    }
}