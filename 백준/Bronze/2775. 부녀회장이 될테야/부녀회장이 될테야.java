import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int floor = Integer.parseInt(br.readLine());
            int room = Integer.parseInt(br.readLine());

            int[][] hotel = new int[floor+1][room];
            for(int j = 0; j < room; j++)
                hotel[0][j] = j+1;

            for(int x = 1; x<=floor; x++)
                for (int y = 0; y < room; y++)
                    for(int temp = 0; temp <=y;temp++)
                        hotel[x][y] += hotel[x-1][temp];

            System.out.println(hotel[floor][room-1]);
        }
    }
}

