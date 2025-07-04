import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        Square[] squares = new Square[n];
        int[][] paper = new int[100][100];

        for(int i = 0;i < n;i++) {
            String[] s = br.readLine().split(" ");
            squares[i] = new Square(parseInt(s[0]), parseInt(s[1]));
        }

        for(Square square : squares) {
            int x = square.x;
            int y = square.y;
            for(int i = x;i < x+10;i++) {
                for(int j = y;j < y+10;j++) {
                    paper[i][j] = 1;
                }
            }
        }

        int total = 0;
        for(int[] p :paper){
            for(int black : p){
                total+=black;
            }
        }

        System.out.println(total);
    }

    static class Square{
        int x;
        int y;

        public Square(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}