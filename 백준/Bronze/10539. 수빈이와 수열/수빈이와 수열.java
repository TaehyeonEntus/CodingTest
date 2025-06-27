import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strArr= sc.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(strArr[i]) * (i+1);
            for(int j = 0; j<i; j++){
                temp -= arr[j];
            }
            arr[i] = temp;
        }
        for(int x : arr)
            System.out.print(x+" ");
    }
}