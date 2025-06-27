import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer min = null;
        Integer max = null;
        while (st.hasMoreTokens()) {
            int i = Integer.parseInt(st.nextToken());
            if(min == null) {
                min = i;
                max = i;
            }
            
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        System.out.println(min + " " + max);
    }
}