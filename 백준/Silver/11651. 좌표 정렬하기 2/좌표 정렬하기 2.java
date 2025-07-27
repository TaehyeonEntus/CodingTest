import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer i = Integer.valueOf(br.readLine());

        List<XY> list = new ArrayList<>();
        for(int j = 0; j < i; j++) {
            String[] s = br.readLine().split(" ");
            list.add(new XY(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }

        list.sort(Comparator.comparing(XY::getY).thenComparing(XY::getX));

        for(XY xy : list) {
            System.out.println(xy.getX() + " " + xy.getY());
        }
    }
    public static class XY{
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
