import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = parseInt(sc.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i<n; i++){
            String[] s = sc.nextLine().split(" ");
            int festival1 = parseInt(s[0]);
            int festival2 = parseInt(s[1]);


            int price1;
            int price2 = 5_120_000;

            if(festival1>21)
                price1 = 0;
            else if(festival1>15)
                price1 = 100_000;
            else if(festival1>10)
                price1 = 300_000;
            else if(festival1>6)
                price1 = 500_000;
            else if(festival1>3)
                price1 = 2_000_000;
            else if(festival1>1)
                price1 = 3_000_000;
            else if(festival1>0)
                price1 = 5_000_000;
            else
                price1 = 0;

            double rank = Math.log(festival2) / Math.log(2);
            if(rank>=5)
                price2=0;
            else if(rank>=4)
                price2/=(int)Math.pow(2,4);
            else if(rank>=3)
                price2/=(int)Math.pow(2,3);
            else if(rank>=2)
                price2/=(int)Math.pow(2,2);
            else if(rank>=1)
                price2/=(int)Math.pow(2,1);
            else if(rank<0)
                price2 = 0;

            arr[i] = price1+price2;
        }
        for (int i : arr){
            System.out.println(i);
        }
    }
}