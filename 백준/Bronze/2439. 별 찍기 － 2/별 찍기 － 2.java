import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stars = scanner.nextInt();
        for(int j = 1; j<=stars; j++){
            for(int i = stars-j; i>0; i--)
                System.out.print(" ");
            for(int k = 0; k<j; k++)
                System.out.print("*");
            System.out.println("");
        }
    }
}