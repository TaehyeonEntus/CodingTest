import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int[] regularPieces = {1, 1, 2, 2, 2, 8};
        for (int i = 0; i < 6; i++) {
            System.out.print((regularPieces[i] - Integer.parseInt(strArr[i]))+" ");
        }
    }
}
