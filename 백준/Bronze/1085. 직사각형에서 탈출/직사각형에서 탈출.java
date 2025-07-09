import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int curX = Integer.parseInt(s[0]);
        int curY = Integer.parseInt(s[1]);
        int w = Integer.parseInt(s[2]);
        int h = Integer.parseInt(s[3]);

        curX = (curX<w-curX)?curX:w-curX;
        curY = (curY<h-curY)?curY:h-curY;

        System.out.println(Math.min(curX, curY));
    }
}