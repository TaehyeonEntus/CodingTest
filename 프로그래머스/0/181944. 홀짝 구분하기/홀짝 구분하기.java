import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String evenOrOdd;
        if(n%2==0)
            evenOrOdd = "even";
        else
            evenOrOdd = "odd";
        System.out.println(n + " is " +evenOrOdd);
    }
}