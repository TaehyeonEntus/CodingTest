import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            String oldNumber = String.valueOf(i);
            String newNumber = oldNumber.replaceAll("3", "").replaceAll("6","").replaceAll("9","");
            int oldLen = oldNumber.length();
            int newLen = newNumber.length();
            if(oldLen == newLen)
                sb.append(i).append(" ");
            else {
                for(int j = 0; j < oldLen-newLen; j++)
                    sb.append("-");
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}