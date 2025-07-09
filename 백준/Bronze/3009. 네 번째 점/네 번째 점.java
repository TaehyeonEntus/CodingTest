import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> xList = new LinkedList<>();
        List<Integer> yList = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            if(xList.contains(x)) {
                xList.remove(xList.indexOf(x));
            } else{
                xList.add(x);
            }
            if(yList.contains(y)) {
                yList.remove(yList.indexOf(y));
            } else{
                yList.add(y);
            }
        }

        System.out.println(xList.get(0)+" "+yList.get(0));
    }
}