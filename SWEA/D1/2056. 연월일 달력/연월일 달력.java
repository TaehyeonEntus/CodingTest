import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            String date = br.readLine();

            String year = date.substring(0, 4);
            int yearNum = Integer.parseInt(year);
            String month = date.substring(4, 6);
            int monthNum = Integer.parseInt(month);
            String day = date.substring(6, 8);
            int dayNum = Integer.parseInt(day);
            if (monthNum < 1 || monthNum > 12) {
                sb.append(-1);
            } else {
                if (dayNum < 1 || dayNum > 31) {
                    sb.append(-1);
                } else {
                    if((monthNum == 4 || monthNum == 6 || monthNum == 9 || monthNum == 11) && dayNum > 30)
                        sb.append(-1);
                    else if(monthNum == 2 && dayNum > 28)
                        sb.append(-1);
                    else
                        sb.append(year).append("/").append(month).append("/").append(day);
                }
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}