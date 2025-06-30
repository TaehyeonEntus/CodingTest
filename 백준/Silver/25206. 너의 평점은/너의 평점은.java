import java.io.*;
import java.security.Key;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double credit = 0;
        double total = 0;
        for (int i = 0; i < 20; i++) {
            String[] str = br.readLine().split(" ");
            double numberGrade = Double.parseDouble(str[1]);
            String alphabetGrade = str[2];

            if (alphabetGrade.equals("A+")) {
                total += numberGrade * 4.5;
            } else if (alphabetGrade.equals("A0")) {
                total += numberGrade * 4.0;
            } else if (alphabetGrade.equals("B+")) {
                total += numberGrade * 3.5;
            } else if (alphabetGrade.equals("B0")) {
                total += numberGrade * 3.0;
            } else if (alphabetGrade.equals("C+")) {
                total += numberGrade * 2.5;
            } else if (alphabetGrade.equals("C0")) {
                total += numberGrade * 2.0;
            } else if (alphabetGrade.equals("D+")) {
                total += numberGrade * 1.5;
            } else if (alphabetGrade.equals("D0")) {
                total += numberGrade;
            } else if (alphabetGrade.equals("P")) {
                continue;
            }
            credit += numberGrade;
        }

        System.out.println(total/credit);
    }
}
